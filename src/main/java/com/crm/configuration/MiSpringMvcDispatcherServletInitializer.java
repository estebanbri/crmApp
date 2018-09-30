package com.crm.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MiSpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
    	return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {PersistenceConfiguration.class, AppConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}