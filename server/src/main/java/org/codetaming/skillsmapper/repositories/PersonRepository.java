package org.codetaming.skillsmapper.repositories;

import org.codetaming.skillsmapper.model.Person;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends GraphRepository<Person> {

    Person findByName(String name);

    Person findByHash(String hash);
}