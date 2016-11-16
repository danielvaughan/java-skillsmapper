package org.codetaming.skillsmapper.client.model;

public class Person {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;

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