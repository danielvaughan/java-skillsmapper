package org.codetaming.skillsmapper.client.model;

public class Hal<O extends Object> {

    O _embedded;

    public O get_embedded() {
        return _embedded;
    }

    public void set_embedded(O _embedded) {
        this._embedded = _embedded;
    }

    @Override
    public String toString() {
        return "Hal{" +
                "_embedded=" + _embedded +
                '}';
    }
}
