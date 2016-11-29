package org.codetaming.skillsmapper.client.model;

public class TitlesWrapper {

    Titles _embedded;

    public Titles get_embedded() {
        return _embedded;
    }

    public void set_embedded(Titles _embedded) {
        this._embedded = _embedded;
    }

    @Override
    public String toString() {
        return "TitlesWrapper{" +
                "_embedded=" + _embedded +
                '}';
    }
}
