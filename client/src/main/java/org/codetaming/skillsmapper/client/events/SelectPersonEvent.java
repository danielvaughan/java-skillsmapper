package org.codetaming.skillsmapper.client.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class SelectPersonEvent extends GwtEvent<SelectPersonEvent.Handler> {

    public static final Type<Handler> TYPE = new Type<>();
    private final String uri;

    public SelectPersonEvent(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public String getId() {
        return uri.substring(uri.lastIndexOf("/") + 1);
    }

    @Override
    public Type<Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onSelectPerson(this);
    }

    @Override
    public String toString() {
        return "SelectPersonEvent{" +
                "uri=" + uri +
                '}';
    }

    public interface Handler extends EventHandler {

        void onSelectPerson(SelectPersonEvent selectPersonEvent);
    }
}
