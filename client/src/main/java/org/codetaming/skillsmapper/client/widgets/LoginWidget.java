package org.codetaming.skillsmapper.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import org.codetaming.skillsmapper.client.auth0.AuthenticationClient;
import org.codetaming.skillsmapper.client.events.LoginEvent;
import org.codetaming.skillsmapper.client.events.LogoutEvent;
import org.gwtbootstrap3.client.ui.Button;

public class LoginWidget extends Composite implements LoginEvent.Handler, LogoutEvent.Handler {

    private static Binder uiBinder = GWT.create(Binder.class);

    private final EventBus eventBus;

    private final AuthenticationClient authenticationClient;

    @UiField
    Button loginButton;

    @UiField
    Button logoutButton;

    @Inject
    public LoginWidget(final EventBus eventBus, final AuthenticationClient authenticationClient) {
        this.eventBus = eventBus;
        this.authenticationClient = authenticationClient;
        initWidget(uiBinder.createAndBindUi(this));
        initListeners();
        initButtons(authenticationClient);
    }

    private void initButtons(AuthenticationClient authenticationClient) {
        loginButton.addClickHandler(event -> {
            authenticationClient.login();
        });
        logoutButton.addClickHandler(event -> {
            authenticationClient.logout();
        });
        recalculateButtons();
    }

    private void initListeners() {
        eventBus.addHandler(LoginEvent.TYPE, this);
        eventBus.addHandler(LogoutEvent.TYPE, this);
    }

    @Override
    public void onLogin(LoginEvent loginEvent) {
        recalculateButtons();
    }

    private void recalculateButtons(){
        boolean loggedIn = authenticationClient.isLoggedIn();
        loginButton.setVisible(!loggedIn);
        logoutButton.setVisible(loggedIn);
    }

    @Override
    public void onLogout(LogoutEvent logoutEvent) {
        recalculateButtons();
    }

    interface Binder extends UiBinder<Widget, LoginWidget> {
    }
}
