package org.codetaming.skillsmapper.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import org.codetaming.skillsmapper.client.events.SelectPersonEvent;
import org.codetaming.skillsmapper.client.events.SelectPersonEventHandler;
import org.codetaming.skillsmapper.client.model.Person;
import org.codetaming.skillsmapper.client.services.PeopleService;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.gwtbootstrap3.client.ui.PageHeader;

import java.util.logging.Logger;

public class ProfileDetailsWidget extends ProtoWidget implements SelectPersonEventHandler {

    private static final Logger LOGGER = Logger.getLogger("ProfileDetailsWidget");
    private static ProfileDetailsWidget.Binder uiBinder = GWT.create(ProfileDetailsWidget.Binder.class);
    @UiField
    PageHeader nameHeading;
    private EventBus eventBus;

    @Inject
    public ProfileDetailsWidget(SimpleEventBus eventBus) {
        this.eventBus = eventBus;
        initWidget(uiBinder.createAndBindUi(this));
        initListeners();
    }

    private void initListeners() {
        eventBus.addHandler(SelectPersonEvent.TYPE, this);
    }

    @Override
    public void onSelectPerson(SelectPersonEvent selectPersonEvent) {
        reload(selectPersonEvent.getId());
    }

    private void reload(Long id) {
        PeopleService peopleService = GWT.create(PeopleService.class);
        peopleService.getPerson(id, new MethodCallback<Person>() {
            @Override
            public void onFailure(final Method method, final Throwable exception) {
                LOGGER.severe(exception.getMessage());
            }

            @Override
            public void onSuccess(Method method, Person person) {
                nameHeading.setText(person.getName());
            }
        });
    }

    interface Binder extends UiBinder<Widget, ProfileDetailsWidget> {
    }
}
