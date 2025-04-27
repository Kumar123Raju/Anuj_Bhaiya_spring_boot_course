package com.example.ubberApp.ubberApp.config;


import com.example.ubberApp.ubberApp.audit.AuditorAwareImp;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditorAwareImp")
public class AppConfig {



    @Bean
    ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    @Bean
    AuditorAwareImp getAuditorAwareImp(){
        return new AuditorAwareImp();
    }
}
