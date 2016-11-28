package org.codetaming.skillsmapper.client.model;

import java.util.List;

public class Tags {

    List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Tags{" +
                "tags=" + tags +
                '}';
    }

}
