package org.codetaming.skillsmapper.domain;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Tag extends Entity {

    private boolean valid;
    private Long lastMentioned;
    private Long lastSeen;
    private Long validated;
    private String description;
    private String title;
    private boolean queried;

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

    @Override
    public String toString() {
        return "Tag{" +
                "valid=" + valid +
                ", lastMentioned=" + lastMentioned +
                ", lastSeen=" + lastSeen +
                ", validated=" + validated +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", queried=" + queried +
                '}';
    }
}
