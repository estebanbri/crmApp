package com.crm.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CLIENTE")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_CLIENTE")
	private Integer idCliente;
	
	@Column(name="PRIMER_NOMBRE")
	private String primerNombre;

	@Version
	@Column(name="OPTIMISTIC_LOCK_VERSION")
	private Long version;


}
