package org.codetaming.skillsmapper.client.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class PeopleSelectedEvent extends GwtEvent<PeopleSelectedEvent.Handler> {

    public static final Type<PeopleSelectedEvent.Handler> TYPE = new Type<>();

    @Override
    public Type<PeopleSelectedEvent.Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(PeopleSelectedEvent.Handler handler) {
        handler.onPeopleSelected(this);
    }

    @Override
    public String toString() {
        return "PeopleSelectedEvent{}";
    }

    public interface Handler extends EventHandler {

        void onPeopleSelected(PeopleSelectedEvent peopleSelectedEvent);
    }
}
