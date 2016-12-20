package org.codetaming.skillsmapper.client.auth0;

import com.google.gwt.core.client.ScriptInjector;

import java.util.logging.Logger;

public class Auth0 {

    private static final Logger LOGGER = Logger.getLogger(Auth0.class.getName());

    public Auth0() {
        init();
    }

    public void init() {
        LOGGER.info("Loading Auth0");
        ScriptInjector.fromString(Auth0ClientBundle.INSTANCE.auth0().getText())
                .setWindow(ScriptInjector.TOP_WINDOW)
                .inject();
    }
}
