package org.codetaming.skillsmapper.client.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class ProfileSelectedEvent extends GwtEvent<ProfileSelectedEvent.Handler> {

    public static final Type<ProfileSelectedEvent.Handler> TYPE = new Type<>();
    private final String id;

    public ProfileSelectedEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public Type<ProfileSelectedEvent.Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ProfileSelectedEvent.Handler handler) {
        handler.onProfileSelected(this);
    }

    @Override
    public String toString() {
        return "ProfileSelectedEvent{" +
                "id='" + id + '\'' +
                '}';
    }

    public interface Handler extends EventHandler {

        void onProfileSelected(ProfileSelectedEvent profileSelectedEvent);
    }
}
