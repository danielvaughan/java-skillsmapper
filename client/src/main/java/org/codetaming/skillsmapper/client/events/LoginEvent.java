package org.codetaming.skillsmapper.client.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class LoginEvent extends GwtEvent<LoginEvent.Handler> {

    public static final Type<Handler> TYPE = new Type<>();

    @Override
    public Type<Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onLogin(this);
    }

    @Override
    public String toString() {
        return "LoginEvent{}";
    }

    public interface Handler extends EventHandler {

        void onLogin(LoginEvent loginEvent);
    }
}
