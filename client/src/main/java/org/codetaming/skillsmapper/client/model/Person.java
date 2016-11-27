package org.codetaming.skillsmapper.client.model;

public class Person {

    private String name;
    private Long created;
    private String imageUrl;
    private Links _links;

    public Links get_links() {
        return _links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURI() {
        return _links.getSelf().getHref();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", created=" + created +
                ", imageUrl='" + imageUrl + '\'' +
                ", _links=" + _links +
                '}';
    }
}