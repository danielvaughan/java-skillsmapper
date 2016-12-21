package org.codetaming.skillsmapper.client.auth0;

public interface AuthenticationClient {

    void login();

    void logout();

    String getToken();

    boolean isLoggedIn();
}