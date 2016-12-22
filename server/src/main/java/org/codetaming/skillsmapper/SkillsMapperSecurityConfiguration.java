package org.codetaming.skillsmapper;

import com.auth0.spring.security.api.Auth0SecurityConfig;

import org.codetaming.skillsmapper.util.Auth0Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SkillsMapperSecurityConfiguration extends Auth0SecurityConfig {

    private final static Logger LOGGER = LoggerFactory.getLogger(SkillsMapperSecurityConfiguration.class);

    @Bean
    public Auth0Client auth0Client() {
        return new Auth0Client(clientId, issuer);
    }

    @Override
    protected void authorizeRequests(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/profile/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/people/**").authenticated();
    }

}
