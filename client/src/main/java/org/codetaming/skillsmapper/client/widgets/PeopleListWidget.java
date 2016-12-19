package org.codetaming.skillsmapper.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import org.codetaming.skillsmapper.client.events.PeopleSelectedEvent;
import org.codetaming.skillsmapper.client.model.PeopleWrapper;
import org.codetaming.skillsmapper.client.services.PeopleService;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.gwtbootstrap3.client.ui.LinkedGroup;

import java.util.logging.Logger;

public class PeopleListWidget extends Composite implements PeopleSelectedEvent.Handler {

    private static final Logger LOGGER = Logger.getLogger(PeopleListWidget.class.getName());

    private static Binder uiBinder = GWT.create(Binder.class);
    private final EventBus eventBus;
    @UiField
    LinkedGroup linkedGroup;

    @Inject
    public PeopleListWidget(final EventBus eventBus) {
        this.eventBus = eventBus;
        initWidget(uiBinder.createAndBindUi(this));
        initListeners();
    }

    private void initListeners() {
        eventBus.addHandler(PeopleSelectedEvent.TYPE, this);
    }

    private void reload() {
        PeopleService peopleService = GWT.create(PeopleService.class);
        peopleService.getPeopleWithProfile(new MethodCallback<PeopleWrapper>() {
            @Override
            public void onFailure(final Method method, final Throwable exception) {
                LOGGER.severe(exception.getMessage());
            }

            @Override
            public void onSuccess(Method method, PeopleWrapper response) {
                response.get_embedded().getPeople().forEach(person ->
                {
                    linkedGroup.add(new PersonListItemWidget(person, eventBus));
                });
            }
        });
    }

    @Override
    public void onPeopleSelected(PeopleSelectedEvent peopleSelectedEvent) {
        reload();
    }

    interface Binder extends UiBinder<Widget, PeopleListWidget> {
    }
}
