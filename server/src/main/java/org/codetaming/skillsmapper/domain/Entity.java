package org.codetaming.skillsmapper.domain;

import org.neo4j.ogm.annotation.GraphId;

public abstract class Entity {

    @GraphId
    Long id;
    protected Long created;
    protected String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", created=" + created +
                ", name='" + name + '\'' +
                '}';
    }
}
