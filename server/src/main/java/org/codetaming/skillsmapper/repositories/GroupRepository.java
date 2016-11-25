package org.codetaming.skillsmapper.repositories;

import org.codetaming.skillsmapper.domain.Group;
import org.codetaming.skillsmapper.domain.Tag;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "groups", path = "groups")
public interface GroupRepository extends GraphRepository<Group> {

    Tag findByName(String name);
}
