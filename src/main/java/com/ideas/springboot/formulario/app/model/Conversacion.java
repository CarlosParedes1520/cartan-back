package com.ideas.springboot.formulario.app.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "t_conversacion")
public class Conversacion {

	// variables
	@Id
	@Column(name = "id_conversacional")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "t_conversacion")
	private Long id_conversacional;

	@NotEmpty(message = "El identificador es requerido")
	@Column(name = "identificador")
	private String identificador;

	@NotEmpty(message = "El sistema es requerido")
	@Column(name = "sistema")
	private String sistema;

	@NotNull(message = "La fecha es requerida")
	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;

	// relacion bidireccional
	@JsonIgnoreProperties(value = { "conversacion", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conversacion", cascade = CascadeType.ALL)
	private List<Detalle> detalles;

	// Get y set
	public Long getId_conversacional() {
		return id_conversacional;
	}

	public void setId_conversacional(Long id_conversacional) {
		this.id_conversacional = id_conversacional;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}
}
