package org.codetaming.skillsmapper;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SkillsMapperNeo4jConfiguration.class)
@ActiveProfiles(profiles = "test")
public abstract class ProtoIntegrationTest {

    protected static final String NAME = "Daniel Vaughan";
    protected static final String HASH = "b4f06f0d4337c3af720f37ef402c1ad9d6f3058f";
}
