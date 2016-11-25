package org.codetaming.skillsmapper.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Group extends Entity {

    @Relationship(type = "MEMBER_OF", direction = Relationship.INCOMING)
    private Set<Person> people = new HashSet<>();

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Group{" +
                "people=" + people +
                '}';
    }
}
