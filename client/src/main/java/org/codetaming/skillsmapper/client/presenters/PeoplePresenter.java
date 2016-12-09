package org.codetaming.skillsmapper.client.presenters;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import java.util.logging.Logger;

public class PeoplePresenter extends AbstractActivity {

    private static final Logger LOGGER = Logger.getLogger("PeoplePresenter");

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        LOGGER.info("start");
    }
}
