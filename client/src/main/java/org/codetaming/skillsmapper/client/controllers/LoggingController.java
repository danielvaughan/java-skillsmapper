package org.codetaming.skillsmapper.client.controllers;

import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import org.codetaming.skillsmapper.client.events.LoginEvent;
import org.codetaming.skillsmapper.client.events.LogoutEvent;
import org.codetaming.skillsmapper.client.events.PeopleSelectedEvent;
import org.codetaming.skillsmapper.client.events.ProfileSelectedEvent;
import org.codetaming.skillsmapper.client.events.SelectPersonEvent;

import java.util.logging.Logger;

public class LoggingController implements SelectPersonEvent.Handler, PlaceChangeEvent.Handler, ProfileSelectedEvent.Handler, PeopleSelectedEvent.Handler, LoginEvent.Handler, LogoutEvent.Handler {

    private static final Logger LOGGER = Logger.getLogger(LoggingController.class.getName());

    private final EventBus eventBus;

    @Inject
    public LoggingController(final EventBus eventBus) {
        this.eventBus = eventBus;
        initListeners();
    }

    private void initListeners() {
        eventBus.addHandler(SelectPersonEvent.TYPE, this);
        eventBus.addHandler(PlaceChangeEvent.TYPE, this);
        eventBus.addHandler(ProfileSelectedEvent.TYPE, this);
        eventBus.addHandler(PeopleSelectedEvent.TYPE, this);
        eventBus.addHandler(LoginEvent.TYPE, this);
        eventBus.addHandler(LogoutEvent.TYPE, this);
    }

    @Override
    public void onSelectPerson(SelectPersonEvent selectPersonEvent) {
        LOGGER.info("Select person: " + selectPersonEvent.getUri());
    }

    @Override
    public void onPlaceChange(PlaceChangeEvent event) {
        LOGGER.info("Place changed: " + event.getNewPlace().toString());
    }

    @Override
    public void onProfileSelected(ProfileSelectedEvent profileSelectedEvent) {
        LOGGER.info("Profile selected: " + profileSelectedEvent.getId());
    }

    @Override
    public void onPeopleSelected(PeopleSelectedEvent peopleSelectedEvent) {
        LOGGER.info("People selected");
    }

    @Override
    public void onLogin(LoginEvent loginEvent) {
        LOGGER.info("Login");
    }

    @Override
    public void onLogout(LogoutEvent logoutEvent) {
        LOGGER.info("Logout");
    }
}
