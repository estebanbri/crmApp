package com.crm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.crm.component") //defino el package-name donde quiero que scanee para encontrar mis @Components y automaticamente registrarlos como beans en el spring-container.
@PropertySource("application.properties") //referencio a mi properties file
public class AppConfiguration {

    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/view/");
        bean.setSuffix(".jsp");
        return bean;
    }


}