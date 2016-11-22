package org.codetaming.skillsmapper.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Person {

    @GraphId
    Long id;

    @Relationship(type = "I_AM_INTERESTED_IN", direction = Relationship.OUTGOING)
    private Set<Tag> interested = new HashSet<>();

    @Relationship(type = "I_AM_LEARNING", direction = Relationship.OUTGOING)
    private Set<Tag> learning = new HashSet<>();

    @Relationship(type = "I_AM_USING", direction = Relationship.OUTGOING)
    private Set<Tag> using = new HashSet<>();

    @Relationship(type = "I_HAVE_USED", direction = Relationship.OUTGOING)
    private Set<Tag> used = new HashSet<>();

    private String name;
    private Long created;
    private String imageUrl;
    private String hash;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreated() {
        return created;
    }

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

    public Set<Tag> getUsing() {
        return using;
    }

    public void addUsing(Tag tag) {
        using.add(tag);
    }

    public Set<Tag> getInterested() {
        return interested;
    }

    public Set<Tag> getLearning() {
        return learning;
    }
    
    public Set<Tag> getUsed() {
        return used;
    }

    public void addInterested(Tag tag) {
        interested.add(tag);
    }

    public void addLearning(Tag tag) {
        learning.add(tag);
    }

    public void addUsed(Tag tag) {
        used.add(tag);
    }
}