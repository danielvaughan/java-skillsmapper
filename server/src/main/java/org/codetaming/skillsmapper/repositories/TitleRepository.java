package org.codetaming.skillsmapper.repositories;

import org.codetaming.skillsmapper.domain.Tag;
import org.codetaming.skillsmapper.domain.Title;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "titles", path = "titles")
public interface TitleRepository extends GraphRepository<Title> {

    Tag findByName(String name);
}
