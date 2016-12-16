package org.codetaming.skillsmapper.client.controllers;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import org.codetaming.skillsmapper.client.events.SelectPersonEvent;
import org.codetaming.skillsmapper.client.events.SelectPersonEventHandler;

import java.util.logging.Logger;

public class LoggingController implements SelectPersonEventHandler {

    private static final Logger LOGGER = Logger.getLogger(LoggingController.class.getName());

    private final EventBus eventBus;

    @Inject
    public LoggingController(final EventBus eventBus) {
        this.eventBus = eventBus;
        initListeners();
    }

    private void initListeners() {
        eventBus.addHandler(SelectPersonEvent.TYPE, this);
    }

    @Override
    public void onSelectPerson(SelectPersonEvent selectPersonEvent) {
        LOGGER.info("Select person: " + selectPersonEvent.getUri());
    }
}
