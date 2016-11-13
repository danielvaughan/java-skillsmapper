package org.codetaming.skillsmapper.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Person {

    @GraphId
    Long id;

    private String name;

    public Long getCreated() {
        return created;
    }

    private Long created;
    private String imageUrl;
    private String hash;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", imageUrl='" + imageUrl + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }

    public void setCreated(Long created) {
        this.created = created;
    }
}