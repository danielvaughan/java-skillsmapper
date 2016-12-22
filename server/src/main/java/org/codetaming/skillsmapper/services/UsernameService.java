package org.codetaming.skillsmapper.services;

import com.auth0.spring.security.api.Auth0JWTToken;
import com.auth0.spring.security.api.Auth0UserDetails;

import org.codetaming.skillsmapper.util.Auth0Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UsernameService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UsernameService.class);

    @Autowired
    private Auth0Client auth0Client;

    public String getUsername() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final Auth0UserDetails principal = (Auth0UserDetails) authentication.getPrincipal();
        LOGGER.info("Current user accessed Admin secured resource: " + principal.getUsername());
        return auth0Client.getUsername((Auth0JWTToken) authentication);
    }

}
