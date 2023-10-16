package com.ideas.springboot.formulario.app.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "t_reporte")
public class ReporteFecha {

	// variables
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "t_reporte")
	private Long id;
	
	@NotNull(message = "La fecha es requerida")
	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date fechaDeVenta;
	
//     @ManyToOne
//	 @JoinColumn(name = "id_conseccionario")
//	 private Conseccionario conseccionario;

	public Date getFechaDeVenta() {
		return fechaDeVenta;
	}

	public void setFechaDeVenta(Date fechaDeVenta) {
		this.fechaDeVenta = fechaDeVenta;
	}



}
