package org.codetaming.skillsmapper.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class SelectPersonEvent extends GwtEvent<SelectPersonEventHandler> {

    public static final Type<SelectPersonEventHandler> TYPE = new Type<SelectPersonEventHandler>();
    private final Long id;

    public SelectPersonEvent(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
                "id=" + id +
                '}';
    }
}
