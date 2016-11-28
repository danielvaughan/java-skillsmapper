package org.codetaming.skillsmapper.client.model;

public class TagsWrapper {

    Tags _embedded;

    public Tags get_embedded() {
        return _embedded;
    }

    public void set_embedded(Tags _embedded) {
        this._embedded = _embedded;
    }

    @Override
    public String toString() {
        return "TagsWrapper{" +
                "_embedded=" + _embedded +
                '}';
    }
}
