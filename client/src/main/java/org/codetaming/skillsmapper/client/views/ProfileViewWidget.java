package org.codetaming.skillsmapper.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import org.codetaming.skillsmapper.client.events.PeopleSelectedEvent;
import org.codetaming.skillsmapper.client.events.ProfileSelectedEvent;
import org.codetaming.skillsmapper.client.model.GroupsWrapper;
import org.codetaming.skillsmapper.client.model.Person;
import org.codetaming.skillsmapper.client.model.TitlesWrapper;
import org.codetaming.skillsmapper.client.services.PeopleService;
import org.codetaming.skillsmapper.client.widgets.ProfileDetailsWidget;
import org.codetaming.skillsmapper.client.widgets.ProtoWidget;
import org.codetaming.skillsmapper.client.widgets.SkillsWidget;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.logging.Logger;

public class ProfileViewWidget extends ProtoWidget implements PeopleSelectedEvent.Handler, ProfileSelectedEvent.Handler {

    private static final Logger LOGGER = Logger.getLogger(ProfileViewWidget.class.getName());

    private static Binder uiBinder = GWT.create(ProfileViewWidget.Binder.class);
    private final EventBus eventBus;
    @UiField(provided = true)
    ProfileDetailsWidget profileDetailsWidget;
    @UiField(provided = true)
    SkillsWidget skillsWidget;
    private PeopleService peopleService = GWT.create(PeopleService.class);

    @Inject
    public ProfileViewWidget(final EventBus eventBus, final ProfileDetailsWidget profileDetailsWidget, SkillsWidget skillsWidget) {
        this.eventBus = eventBus;
        this.profileDetailsWidget = profileDetailsWidget;
        this.skillsWidget = skillsWidget;
        initWidget(uiBinder.createAndBindUi(this));
        initListeners();
    }

    private void initListeners() {
        eventBus.addHandler(ProfileSelectedEvent.TYPE, this);
        eventBus.addHandler(PeopleSelectedEvent.TYPE, this);
    }

    private void loadTitles(String id) {
        profileDetailsWidget.clearTitles();
        peopleService.getTitles(id, new MethodCallback<TitlesWrapper>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                LOGGER.severe(exception.getMessage());
            }

            @Override
            public void onSuccess(Method method, TitlesWrapper response) {
                profileDetailsWidget.showTitles(response.get_embedded().getTitles());
            }
        });
    }

    private void loadGroups(String id) {
        profileDetailsWidget.clearGroups();
        peopleService.getGroups(id, new MethodCallback<GroupsWrapper>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                LOGGER.severe(exception.getMessage());
            }

            @Override
            public void onSuccess(Method method, GroupsWrapper response) {
                profileDetailsWidget.showGroups(response.get_embedded().getGroups());
            }
        });
    }

    private void loadPerson(String id) {
        profileDetailsWidget.clearPerson();
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

    @Override
    public void onProfileSelected(ProfileSelectedEvent profileSelectedEvent) {
        setVisible(true);
        String id = profileSelectedEvent.getId();
        loadPerson(id);
        loadGroups(id);
        loadTitles(id);
    }

    @Override
    public void onPeopleSelected(PeopleSelectedEvent peopleSelectedEvent) {
        setVisible(false);
    }

    interface Binder extends UiBinder<Widget, ProfileViewWidget> {
    }
}
