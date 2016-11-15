package org.codetaming.skillsmapper.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import org.codetaming.skillsmapper.client.domain.Hal;
import org.codetaming.skillsmapper.client.domain.People;
import org.codetaming.skillsmapper.client.domain.Person;
import org.codetaming.skillsmapper.client.services.PeopleService;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.gwtbootstrap3.client.ui.LinkedGroup;
import org.gwtbootstrap3.client.ui.LinkedGroupItem;

import java.util.logging.Logger;

public class PeopleListWidget extends Composite {

    private static final Logger LOGGER = Logger.getLogger("PeopleListWidget");

    private static Binder uiBinder = GWT.create(Binder.class);

    @UiField
    LinkedGroup linkedGroup;

    private EventBus eventBus;

    @Inject
    public PeopleListWidget(SimpleEventBus eventBus) {
        this.eventBus = eventBus;
        initWidget(uiBinder.createAndBindUi(this));
        reload();
    }

    interface Binder extends UiBinder<Widget, PeopleListWidget> {
    }

    private void reload() {
        PeopleService peopleService = GWT.create(PeopleService.class);
        peopleService.getPeople(new MethodCallback<Hal<People>>() {
            @Override
            public void onFailure(final Method method, final Throwable exception) {
                LOGGER.severe(exception.getMessage());
            }

            @Override
            public void onSuccess(Method method, Hal<People> response) {
                LOGGER.info(response.getPage().toString());
                response.get_embedded().getPeople().forEach(person -> addItem(person));
            }
        });
    }

    private void addItem(final Person person) {
        LinkedGroupItem linkedGroupItem = new LinkedGroupItem(person.getName(), person.getImageUrl());
        linkedGroup.add(linkedGroupItem);
    }
}