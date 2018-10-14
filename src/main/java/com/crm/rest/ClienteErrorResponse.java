package com.crm.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteErrorResponse {
	
	private int status;
	private String mensaje;
	private long timestamp;

}
