package org.codetaming.skillsmapper;

import org.codetaming.skillsmapper.domain.Person;
import org.codetaming.skillsmapper.repositories.PersonRepository;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class ProtoEmbeddedTest {

    protected static final String NAME = "Daniel Vaughan";
    protected static final String HASH = "7dcb0cd247aa94896e665c337696a7be18d387a78d6d55b4854b7ff7d5925042";
    protected static final String IMAGE_URL = "http://common.gcscc.site/img/silhouette.png";

    @Autowired
    protected PersonRepository instance;

    @Before
    public void initialize() {
        System.out.println("seeding embedded database");
        Person person = new Person();
        person.setName(NAME);
        person.setHash(HASH);
        person.setImageUrl(IMAGE_URL);
        instance.save(person);
    }
}
