package org.codetaming.skillsmapper.repositories;

import org.codetaming.skillsmapper.domain.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Set;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends GraphRepository<Person> {

    Person findByName(String name);

    Person findByHash(String hash);

    @Query("match (p:Person)-[r]->(t:Tag) where p.name is not null and p.hash is not null return p order by p.name")
    Set<Person> findWithProfile();

    Person findByEmail(String email);
}