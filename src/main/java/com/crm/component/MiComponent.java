package com.crm.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MiComponent {
	
	@Value("${cliente.nombre}")
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}

}
