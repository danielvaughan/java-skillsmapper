package org.codetaming.skillsmapper.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class SelectPersonEvent extends GwtEvent<SelectPersonEventHandler> {

    public static final Type<SelectPersonEventHandler> TYPE = new Type<>();

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
    public Type<SelectPersonEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(SelectPersonEventHandler selectPersonEventHandler) {
        selectPersonEventHandler.onSelectPerson(this);
    }

    @Override
    public String toString() {
        return "SelectPersonEvent{" +
                "uri=" + uri +
                '}';
    }
}
