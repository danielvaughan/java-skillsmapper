package org.codetaming.skillsmapper.client.auth0;

import com.google.inject.Inject;

import org.fusesource.restygwt.client.dispatcher.DefaultFilterawareDispatcher;
import org.fusesource.restygwt.client.dispatcher.DispatcherFilter;

public class Auth0Dispatcher extends DefaultFilterawareDispatcher {

    @Inject
    public Auth0Dispatcher(DispatcherFilter dispatcherFilter) {
        addFilter(dispatcherFilter);
    }
}
