package org.codetaming.skillsmapper.client.model;

public class Title {

    private String name;
    private Long created;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Title{" +
                "name='" + name + '\'' +
                ", created=" + created +
                '}';
    }
}
