package org.codetaming.skillsmapper;

import org.codetaming.skillsmapper.domain.Person;
import org.codetaming.skillsmapper.domain.Tag;
import org.codetaming.skillsmapper.repositories.PersonRepository;
import org.codetaming.skillsmapper.repositories.TagRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyNeo4jTestConfiguration.class)
@ActiveProfiles(profiles = "test")
public abstract class ProtoEmbeddedTest {

    protected static final String NAME = "Daniel Vaughan";
    protected static final String HASH = "7dcb0cd247aa94896e665c337696a7be18d387a78d6d55b4854b7ff7d5925042";
    protected static final String IMAGE_URL = "http://common.gcscc.site/img/silhouette.png";
    protected static final String TAG_NAME = "java";

    @Autowired
    protected PersonRepository personRepository;

    @Autowired
    protected TagRepository tagRepository;

    @Before
    public void initialize() {
        System.out.println("seeding embedded database");
        Person person = new Person();
        person.setName(NAME);
        person.setHash(HASH);
        person.setImageUrl(IMAGE_URL);
        Tag tag = new Tag();
        tag.setName(TAG_NAME);
        tagRepository.save(tag);
        person.addInterested(tag);
        person.addLearning(tag);
        person.addUsing(tag);
        person.addUsed(tag);
        personRepository.save(person);
    }
}
