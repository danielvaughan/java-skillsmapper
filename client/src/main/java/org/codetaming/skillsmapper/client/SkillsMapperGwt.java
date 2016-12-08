package org.codetaming.skillsmapper.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.inject.Inject;

import org.fusesource.restygwt.client.Defaults;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SkillsMapperGwt implements EntryPoint {

    private static final Logger LOGGER = Logger.getLogger("SkillsMapperGwt");

    //private final SkillsMapperGwtAppGinjector injector = GWT.create(SkillsMapperGwtAppGinjector.class);

    private final SkillsMapperConstants skillsMapperConstants = GWT.create(SkillsMapperConstants.class);

    @Inject
    PlaceHistoryHandler historyHandler;

    /**
     * Detect if the app is in development mode.
     *
     * @return true if in development mode
     */
    private static native boolean isDevelopmentMode()/*-{
        return typeof $wnd.__gwt_sdm !== 'undefined';
    }-*/;

    @Override
    public void onModuleLoad() {
        GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
            public void onUncaughtException(Throwable e) {
                LOGGER.log(Level.SEVERE, "Uncaught Exception: \n", e);
            }
        });
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            public void execute() {
                onModuleLoad2();
            }
        });
    }

    private void onModuleLoad2() {
        try {
            final SkillsMapperGwtAppGinjector injector = GWT.create(SkillsMapperGwtAppGinjector.class);
            injector.inject(this);
            injector.getLoggingController();
            useCorrectRequestBaseUrl();
            RootPanel.get().add(injector.getMainPanel());
            historyHandler.handleCurrentHistory();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error in onModuleLoad2 \n", e);
        }
    }

    private void useCorrectRequestBaseUrl() {
        String serverBaseUrl;
        if (isDevelopmentMode()) {
            serverBaseUrl = skillsMapperConstants.localServerBaseUrl();
        } else {
            serverBaseUrl = skillsMapperConstants.serverBaseUrl();
        }
        LOGGER.log(Level.INFO, "Setting server base URL to: " + serverBaseUrl);
        Defaults.setServiceRoot(serverBaseUrl);
    }
}
