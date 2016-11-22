package org.codetaming.skillsmapper.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Tag {

    @GraphId
    Long id;

    private boolean valid;
    private Long lastMentioned;
    private Long lastSeen;
    private Long validated;
    private Long created;
    private String name;

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", valid=" + valid +
                ", lastMentioned=" + lastMentioned +
                ", lastSeen=" + lastSeen +
                ", validated=" + validated +
                ", created=" + created +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", queried=" + queried +
                '}';
    }

    private String description;
    private String title;
    private boolean queried;

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

    public Long getLastMentioned() {
        return lastMentioned;
    }

    public void setLastMentioned(Long lastMentioned) {
        this.lastMentioned = lastMentioned;
    }

    public Long getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Long lastSeen) {
        this.lastSeen = lastSeen;
    }

    public Long getValidated() {
        return validated;
    }

    public void setValidated(Long validated) {
        this.validated = validated;
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

    public boolean isQueried() {
        return queried;
    }

    public void setQueried(boolean queried) {
        this.queried = queried;
    }


}
