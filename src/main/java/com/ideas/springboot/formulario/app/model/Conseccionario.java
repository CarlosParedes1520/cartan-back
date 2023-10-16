package com.ideas.springboot.formulario.app.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "t_conseccionario")
public class Conseccionario {
	
	// variables
		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "t_conseccionario")
		private Long id;
		
		
		@NotNull(message = "La fecha es requerida")
		@Column(name = "con_fecha_venta")
		@Temporal(TemporalType.TIMESTAMP)
		private LocalDateTime conFechaVenta;
		

		@NotEmpty(message = "La empresa es requerido")
		@Column(name = "con_nom_empresa")
		private String conNomEmpresa;
		
		@NotEmpty(message = "El almacen es requerido")
		@Column(name = "con_nom_almacen")
		private String conNomAlmacen;

		@NotNull(message = "La cantidad es requerido")
		@Column(name = "con_cantidad")
		private int conCantidad;
		
		@NotEmpty(message = "La factura es requerido")
		@Column(name = "con_nom_tipo_factura")
		private String conTipoFactura;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDateTime getConFechaVenta() {
			return conFechaVenta;
		}

		public void setConFechaVenta(LocalDateTime conFechaVenta) {
			this.conFechaVenta = conFechaVenta;
		}

		public String getConNomEmpresa() {
			return conNomEmpresa;
		}

		public void setConNomEmpresa(String conNomEmpresa) {
			this.conNomEmpresa = conNomEmpresa;
		}

		public String getConNomAlmacen() {
			return conNomAlmacen;
		}

		public void setConNomAlmacen(String conNomAlmacen) {
			this.conNomAlmacen = conNomAlmacen;
		}

		public int getConCantidad() {
			return conCantidad;
		}

		public void setConCantidad(int conCantidad) {
			this.conCantidad = conCantidad;
		}

		public String getConTipoFactura() {
			return conTipoFactura;
		}

		public void setConTipoFactura(String conTipoFactura) {
			this.conTipoFactura = conTipoFactura;
		}

}
