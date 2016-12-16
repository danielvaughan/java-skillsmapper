package org.codetaming.skillsmapper.client.controllers;

import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import org.codetaming.skillsmapper.client.events.SelectPersonEvent;
import org.codetaming.skillsmapper.client.events.SelectPersonEventHandler;
import org.codetaming.skillsmapper.client.places.ProfilePlace;

import java.util.logging.Logger;

public class NavigationController implements SelectPersonEventHandler {

    private static final Logger LOGGER = Logger.getLogger("NavigationController");

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
    }

    @Override
    public void onSelectPerson(SelectPersonEvent selectPersonEvent) {
        placeController.goTo(new ProfilePlace(selectPersonEvent.getId()));
    }
}
