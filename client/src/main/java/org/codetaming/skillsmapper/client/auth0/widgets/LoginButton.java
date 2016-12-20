package org.codetaming.skillsmapper.client.auth0.widgets;

import com.google.gwt.core.client.GWT;

import org.codetaming.skillsmapper.client.auth0.Auth0Constants;
import org.gwtbootstrap3.client.ui.Button;

import java.util.logging.Logger;

import static org.gwtbootstrap3.client.ui.constants.IconType.SIGN_IN;

public class LoginButton extends Button {

    private static final Logger LOGGER = Logger.getLogger(LoginButton.class.getName());

    private final Auth0Constants auth0Constants = GWT.create(Auth0Constants.class);

    public LoginButton() {
        super();
        setId("btn-login");
        setText("Login");
        setIcon(SIGN_IN);
        addClickHandler(event -> {
            LOGGER.info("Login: " + auth0Constants.auth0Domain());
            login(auth0Constants.auth0ClientId(), auth0Constants.auth0Domain());
        });
    }

    private final native void login(String auth0ClientId, String auth0Domain) /*-{
        var lock = new $wnd.Auth0Lock(auth0ClientId, auth0Domain);
        lock.show();
    }-*/;

}
