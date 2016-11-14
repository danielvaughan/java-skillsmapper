package org.codetaming.skillsmapper.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import org.fusesource.restygwt.client.Defaults;

/**
 * This class is used as entry point for our GWT application. It configures the app and adds the UI.
 *
 * @author Fabian Dietenberger
 */
public class SkillsMapperGwt implements EntryPoint {

    public void onModuleLoad() {
        useCorrectRequestBaseUrl();
        RootPanel.get().add(new Label("Hello"));
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
