package org.codetaming.skillsmapper.client.model;

public class Tag {

    Long id;
    private boolean valid;
    private String name;
    private String description;
    private String title;

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", valid=" + valid +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
