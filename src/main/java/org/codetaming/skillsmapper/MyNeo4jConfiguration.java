package org.codetaming.skillsmapper;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableScheduling
@EnableAutoConfiguration
@ComponentScan(basePackages = {"org.codetaming.skillsmapper.services"})
@Configuration
@EnableNeo4jRepositories(basePackages = "org.codetaming.skillsmapper.repositories")
public class MyNeo4jConfiguration extends Neo4jConfiguration {

    @Override
    public SessionFactory getSessionFactory() {
        return new SessionFactory("org.codetaming.skillsmapper.domain");
    }
}