package org.codetaming.skillsmapper.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Person extends Entity {

    private String imageUrl;

    @JsonIgnore
    private String hash;

    @Relationship(type = "I_AM_INTERESTED_IN", direction = Relationship.OUTGOING)
    private Set<Tag> interested = new HashSet<>();

    @Relationship(type = "I_AM_LEARNING", direction = Relationship.OUTGOING)
    private Set<Tag> learning = new HashSet<>();

    @Relationship(type = "I_AM_USING", direction = Relationship.OUTGOING)
    private Set<Tag> using = new HashSet<>();

    @Relationship(type = "I_HAVE_USED", direction = Relationship.OUTGOING)
    private Set<Tag> used = new HashSet<>();

    @Relationship(type = "MEMBER_OF", direction = Relationship.OUTGOING)
    private Set<Group> groups = new HashSet<>();

    @Relationship(type = "IS_IN", direction = Relationship.OUTGOING)
    private Set<Room> rooms = new HashSet<>();

    @Relationship(type = "HAS_TITLE", direction = Relationship.OUTGOING)
    private Set<Title> titles = new HashSet<>();

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Set<Title> getTitles() {
        return titles;
    }

    public void setTitles(Set<Title> titles) {
        this.titles = titles;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", hash='" + hash + '\'' +
                ", interested=" + interested +
                ", learning=" + learning +
                ", using=" + using +
                ", used=" + used +
                '}';
    }
}