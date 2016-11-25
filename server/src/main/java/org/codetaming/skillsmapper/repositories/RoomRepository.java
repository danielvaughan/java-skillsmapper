package org.codetaming.skillsmapper.repositories;

import org.codetaming.skillsmapper.domain.Room;
import org.codetaming.skillsmapper.domain.Tag;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "rooms", path = "rooms")
public interface RoomRepository extends GraphRepository<Room> {

    Tag findByName(String name);
}
