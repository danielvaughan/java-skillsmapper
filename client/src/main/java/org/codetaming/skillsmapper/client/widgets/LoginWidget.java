package org.codetaming.skillsmapper.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import org.codetaming.skillsmapper.client.auth0.AuthenticationClient;
import org.gwtbootstrap3.client.ui.Button;

public class LoginWidget extends Composite {

    private static Binder uiBinder = GWT.create(Binder.class);

    @UiField
    Button loginButton;

    @Inject
    public LoginWidget(AuthenticationClient authenticationClient) {
        initWidget(uiBinder.createAndBindUi(this));
        loginButton.addClickHandler(event -> {
            authenticationClient.login();
        });
    }

    interface Binder extends UiBinder<Widget, LoginWidget> {
    }
}
