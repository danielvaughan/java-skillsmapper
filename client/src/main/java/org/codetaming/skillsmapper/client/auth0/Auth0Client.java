package org.codetaming.skillsmapper.client.auth0;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;

import java.util.logging.Logger;

public class Auth0Client implements AuthenticationClient {

    private static final Logger LOGGER = Logger.getLogger(Auth0Client.class.getName());

    private final Auth0Constants auth0Constants = GWT.create(Auth0Constants.class);

    public Auth0Client() {
        init();
    }

    public void init() {
        LOGGER.info("Loading Auth0");
        ScriptInjector.fromString(Auth0ClientBundle.INSTANCE.auth0().getText())
                .setWindow(ScriptInjector.TOP_WINDOW)
                .inject();
    }

    @Override
    public void login() {
        login(auth0Constants.auth0ClientId(), auth0Constants.auth0Domain());
    }

    @Override
    public void logout() {

    }

    @Override
    public void retrieveProfile() {

    }

    private void authenticated(String authResult) {
        LOGGER.info("Authenticated: " + authResult);
    }

    private final native void login(String auth0ClientId, String auth0Domain) /*-{
        var lock = new $wnd.Auth0Lock(auth0ClientId, auth0Domain);
        var self = this;
        var callback = $entry(function (authResult) {
            self.@org.codetaming.skillsmapper.client.auth0.Auth0Client::authenticated(Ljava/lang/String;)(authResult);
        });
        lock.on("authenticated", callback);
        lock.show();
    }-*/;
}
