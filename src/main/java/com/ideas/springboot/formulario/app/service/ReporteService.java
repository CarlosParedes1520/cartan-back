package com.ideas.springboot.formulario.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas.springboot.formulario.app.model.Conseccionario;
import com.ideas.springboot.formulario.app.model.ReporteFecha;
import com.ideas.springboot.formulario.app.repository.IReporte;

@Service
public class ReporteService {

	
	@Autowired
	private IReporte repo;
	
	// Servicio para crear ReporteFecha
	public ReporteFecha crearReporteFecha(ReporteFecha reporteFecha) {
		return repo.save(reporteFecha);
	}
	
	
	// Servicio para Listar Conseccionario
	public List<ReporteFecha> listarReporteFecha() {
		return repo.findAll();
	}
	
}
