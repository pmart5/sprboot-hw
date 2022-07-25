package com.pmart5a.sprboothw.config;

import com.pmart5a.sprboothw.service.DevProfileImpl;
import com.pmart5a.sprboothw.service.ProductionProfileImpl;
import com.pmart5a.sprboothw.service.SystemProfile;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    @ConditionalOnProperty(value = "netology.profile.dev", havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfileImpl();
    }

    @Bean
    @ConditionalOnProperty(value = "netology.profile.dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfileImpl();
    }
}