package org.codetaming.skillsmapper.client.model;

public class GroupsWrapper {

    Groups _embedded;

    public Groups get_embedded() {
        return _embedded;
    }

    public void set_embedded(Groups _embedded) {
        this._embedded = _embedded;
    }

    @Override
    public String toString() {
        return "GroupsWrapper{" +
                "_embedded=" + _embedded +
                '}';
    }
}
