package org.codetaming.skillsmapper.client.controllers;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Inject;

import org.codetaming.skillsmapper.client.events.SelectPersonEvent;
import org.codetaming.skillsmapper.client.events.SelectPersonEventHandler;

import java.util.logging.Logger;

public class LoggingController implements SelectPersonEventHandler {

    private static final Logger LOGGER = Logger.getLogger("LoggingController");

    private EventBus eventBus;

    @Inject
    public LoggingController(SimpleEventBus eventBus) {
        this.eventBus = eventBus;
        initListeners();
    }

    private void initListeners() {
        eventBus.addHandler(SelectPersonEvent.TYPE, this);
    }

    @Override
    public void onSelectPerson(SelectPersonEvent selectPersonEvent) {
        LOGGER.info("Select person: " + selectPersonEvent.getId());
    }
}
