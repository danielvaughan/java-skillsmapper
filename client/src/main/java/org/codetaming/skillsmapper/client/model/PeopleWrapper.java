package org.codetaming.skillsmapper.client.model;

public class PeopleWrapper {

    People _embedded;

    public People get_embedded() {
        return _embedded;
    }

    public void set_embedded(People _embedded) {
        this._embedded = _embedded;
    }

    @Override
    public String toString() {
        return "PeopleWrapper{" +
                "_embedded=" + _embedded +
                '}';
    }
}
