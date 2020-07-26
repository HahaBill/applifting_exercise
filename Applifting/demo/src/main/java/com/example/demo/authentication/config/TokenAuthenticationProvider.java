package com.example.demo.authentication.config;

import com.example.demo.authentication.UserAuthenticationService;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class TokenAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @NonNull
    UserAuthenticationService auth;

    @Override
    protected void additionalAuthenticationChecks( final UserDetails userDetails,
                                                   final UsernamePasswordAuthenticationToken auth) {
        // Nothing to do
    }

    @Override
    protected UserDetails retrieveUser(final String username,
                                       final UsernamePasswordAuthenticationToken authentication) {
        Object token = authentication.getCredentials();

        //    auth.findByToken()
        //    return auth.findByToken(token);
        //        auth.findByToken("te");
        return Optional
                .ofNullable(token)
                .map(String::valueOf)
                .flatMap(auth::findByToken)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Cannot find user with authentication token="
                                + token));
        //  return null;
    }

}
