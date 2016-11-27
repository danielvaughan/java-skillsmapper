package org.codetaming.skillsmapper.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import org.codetaming.skillsmapper.client.events.SelectPersonEvent;
import org.codetaming.skillsmapper.client.events.SelectPersonEventHandler;
import org.codetaming.skillsmapper.client.model.Groups;
import org.codetaming.skillsmapper.client.model.Hal;
import org.codetaming.skillsmapper.client.model.Person;
import org.codetaming.skillsmapper.client.services.PeopleService;
import org.codetaming.skillsmapper.client.widgets.ProfileDetailsWidget;
import org.codetaming.skillsmapper.client.widgets.ProtoWidget;
import org.codetaming.skillsmapper.client.widgets.SkillsWidget;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.logging.Logger;

public class ProfileViewWidget extends ProtoWidget implements SelectPersonEventHandler {

    private static final Logger LOGGER = Logger.getLogger("ProfileViewWidget");

    private static Binder uiBinder = GWT.create(ProfileViewWidget.Binder.class);

    @UiField(provided = true)
    ProfileDetailsWidget profileDetailsWidget;

    @UiField(provided = true)
    SkillsWidget skillsWidget;

    private EventBus eventBus;

    private PeopleService peopleService = GWT.create(PeopleService.class);

    @Inject
    public ProfileViewWidget(SimpleEventBus eventBus, ProfileDetailsWidget profileDetailsWidget, SkillsWidget skillsWidget) {
        this.eventBus = eventBus;
        this.profileDetailsWidget = profileDetailsWidget;
        this.skillsWidget = skillsWidget;
        initWidget(uiBinder.createAndBindUi(this));
        initListeners();
    }

    private void initListeners() {
        eventBus.addHandler(SelectPersonEvent.TYPE, this);
    }

    @Override
    public void onSelectPerson(SelectPersonEvent selectPersonEvent) {
        String id = selectPersonEvent.getId();
        loadPerson(id);
        loadGroups(id);
    }

    private void loadGroups(String id) {
        peopleService.getGroups(id, new MethodCallback<Hal<Groups>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                LOGGER.severe(exception.getMessage());
            }

            @Override
            public void onSuccess(Method method, Hal<Groups> response) {
                profileDetailsWidget.showGroups(response.get_embedded().getGroups());
            }
        });
    }

    private void loadPerson(String id) {
        peopleService.getPerson(id, new MethodCallback<Person>() {
            @Override
            public void onFailure(final Method method, final Throwable exception) {
                LOGGER.severe(exception.getMessage());
            }

            @Override
            public void onSuccess(Method method, Person person) {
                profileDetailsWidget.showPerson(person);
                skillsWidget.showPerson(person);
            }
        });
    }

    interface Binder extends UiBinder<Widget, ProfileViewWidget> {
    }
}
