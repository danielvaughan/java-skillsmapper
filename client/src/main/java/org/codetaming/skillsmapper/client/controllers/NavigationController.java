package org.codetaming.skillsmapper.client.controllers;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import org.codetaming.skillsmapper.client.events.PeopleSelectedEvent;
import org.codetaming.skillsmapper.client.events.ProfileSelectedEvent;
import org.codetaming.skillsmapper.client.events.SelectPersonEvent;
import org.codetaming.skillsmapper.client.places.PeoplePlace;
import org.codetaming.skillsmapper.client.places.ProfilePlace;

import java.util.logging.Logger;

public class NavigationController implements SelectPersonEvent.Handler, PlaceChangeEvent.Handler {

    private static final Logger LOGGER = Logger.getLogger(NavigationController.class.getName());

    private final EventBus eventBus;

    private final PlaceController placeController;

    @Inject
    public NavigationController(final EventBus eventBus, final PlaceController placeController) {
        this.eventBus = eventBus;
        this.placeController = placeController;
        initListeners();
    }

    private void initListeners() {
        eventBus.addHandler(SelectPersonEvent.TYPE, this);
        eventBus.addHandler(PlaceChangeEvent.TYPE, this);
    }

    @Override
    public void onSelectPerson(SelectPersonEvent selectPersonEvent) {
        placeController.goTo(new ProfilePlace(selectPersonEvent.getId()));
    }

    @Override
    public void onPlaceChange(PlaceChangeEvent event) {
        Place place = event.getNewPlace();
        if (place instanceof PeoplePlace) {
            eventBus.fireEvent(new PeopleSelectedEvent());
            return;
        }
        if (place instanceof ProfilePlace) {
           eventBus.fireEvent(new ProfileSelectedEvent(((ProfilePlace) place).getId()));
           return;
        }
        LOGGER.severe("Invalid place: " + place.toString());
    }
}
