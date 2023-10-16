package com.ideas.springboot.formulario.app.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "t_conversacion_detalle")
public class Detalle {

	// Variables

	@Id
	@Column(name = "id_conversacion_detalle")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "t_conversacion_detalle")
	private Long id_detalle;

	@NotNull(message = "El codigo es requerido")
	@Column(name = "codigo", unique = true)
	private Long codigo;

	@NotEmpty(message = "El rol es requerido")
	@Column(name = "rol")
	private String rol;

	@NotEmpty(message = "El mensaje es requerido")
	@Column(name = "mensaje")
	private String mensaje;

	@NotEmpty(message = "El prompts es requerido")
	@Column(name = "prompts")
	private String prompts;

	@NotNull(message = "La fecha es requerida")
	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;

	// relacion bidireccional
	@NotNull(message = "El Id-conversacion es requerido")
	@JsonIgnoreProperties(value = { "detalles", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_conversacion")
	private Conversacion conversacion;

	// get y set
	public Long getId_detalle() {
		return id_detalle;
	}

	public void setId_detalle(Long id_detalle) {
		this.id_detalle = id_detalle;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Conversacion getConversacion() {
		return conversacion;
	}

	public void setConversacion(Conversacion conversacion) {
		this.conversacion = conversacion;
	}

	public String getPrompts() {
		return prompts;
	}

	public void setPrompts(String prompts) {
		this.prompts = prompts;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
