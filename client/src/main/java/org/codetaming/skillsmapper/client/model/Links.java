package org.codetaming.skillsmapper.client.model;

public class Links {

    private Link self;

    public Link getSelf() {
        return self;
    }

    public void setSelf(Link self) {
        this.self = self;
    }

    @Override
    public String toString() {
        return "Links{" +
                "self=" + self +
                '}';
    }
}