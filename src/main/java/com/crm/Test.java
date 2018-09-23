package com.crm;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.crm.component.MiComponent;
import com.crm.configuration.AppConfiguration;

public class Test {

	public static void main(String[] args) {

        //Se produce un scan de Class-Path para encontrar AppConfiguration.class
		AnnotationConfigApplicationContext springContainer =
                    new AnnotationConfigApplicationContext(AppConfiguration.class);

        MiComponent cliente = springContainer.getBean("miComponent",MiComponent.class);
        System.out.println(cliente.getNombre());
        
        springContainer.close();
        
 
	}

}
