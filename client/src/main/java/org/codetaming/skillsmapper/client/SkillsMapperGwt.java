package org.codetaming.skillsmapper.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.ui.RootPanel;
import org.fusesource.restygwt.client.Defaults;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is used as entry point for our GWT application. It configures the app and adds the UI.
 *
 * @author Fabian Dietenberger
 */
public class SkillsMapperGwt implements EntryPoint {

    private static final Logger LOGGER = Logger.getLogger("SkillsMapperGwt");

    private final SkillsMapperGwtAppGinjector injector = GWT.create(SkillsMapperGwtAppGinjector.class);

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
            injector.getLoggingController();
            RootPanel.get().add(injector.getMainPanel());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error in onModuleLoad2 \n", e);
        }
    }

    private void useCorrectRequestBaseUrl() {
        if (isDevelopmentMode()) {
            Defaults.setServiceRoot("http://localhost:8080");
        } else {
            Defaults.setServiceRoot(GWT.getHostPageBaseURL());
        }
    }

    /**
     * Detect if the app is in development mode.
     *
     * @return true if in development mode
     */
    private static native boolean isDevelopmentMode()/*-{
        return typeof $wnd.__gwt_sdm !== 'undefined';
    }-*/;
}
