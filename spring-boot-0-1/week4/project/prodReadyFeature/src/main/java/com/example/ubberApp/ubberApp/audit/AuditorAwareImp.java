package com.example.ubberApp.ubberApp.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImp implements AuditorAware<String>{
    @Override
    public Optional<String> getCurrentAuditor() {
        //get security context
        //get authenticate
        //get priniciple
        //get the username
        return Optional.of("Raju kumar");
    }
}
