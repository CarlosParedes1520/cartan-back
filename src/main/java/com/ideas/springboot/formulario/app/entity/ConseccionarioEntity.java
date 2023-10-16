package com.ideas.springboot.formulario.app.entity;

import jakarta.persistence.Entity;

public class ConseccionarioEntity {

	private String con_nom_empresa;
	private int con_cantidad;
	
	private String con_nom_local;

	public String getCon_nom_empresa() {
		return con_nom_empresa;
	}

	public void setCon_nom_empresa(String con_nom_empresa) {
		this.con_nom_empresa = con_nom_empresa;
	}

	public int getCon_cantidad() {
		return con_cantidad;
	}

	public void setCon_cantidad(int con_cantidad) {
		this.con_cantidad = con_cantidad;
	}

	public String getCon_nom_local() {
		return con_nom_local;
	}

	public void setCon_nom_local(String con_nom_local) {
		this.con_nom_local = con_nom_local;
	}

	
}
