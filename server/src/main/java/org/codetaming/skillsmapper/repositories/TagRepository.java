package org.codetaming.skillsmapper.repositories;

import org.codetaming.skillsmapper.domain.Tag;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tag", path = "tags")
public interface TagRepository extends GraphRepository<Tag> {

}
