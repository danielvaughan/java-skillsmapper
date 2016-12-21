package org.codetaming.skillsmapper.client.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class LogoutEvent extends GwtEvent<LogoutEvent.Handler> {

    public static final Type<Handler> TYPE = new Type<>();

    @Override
    public Type<Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onLogout(this);
    }

    @Override
    public String toString() {
        return "LogoutEvent{}";
    }

    public interface Handler extends EventHandler {

        void onLogout(LogoutEvent logoutEvent);
    }
}
