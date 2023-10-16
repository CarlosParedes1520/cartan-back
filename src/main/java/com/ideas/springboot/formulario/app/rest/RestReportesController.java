package com.ideas.springboot.formulario.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas.springboot.formulario.app.model.Conseccionario;
import com.ideas.springboot.formulario.app.model.ReporteFecha;
import com.ideas.springboot.formulario.app.service.ConseccionariaService;
import com.ideas.springboot.formulario.app.service.ReporteService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/reporte")
public class RestReportesController {

	
	@Autowired
	private ReporteService reporteService;

	// agregar Reportes
	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	public ReporteFecha registrarCliente(@RequestBody @Valid ReporteFecha reportes) {

		return reporteService.crearReporteFecha(reportes);
	}
	
	
	// Listar Reportes
	@GetMapping(path = "/list", produces = "application/json")
	public List<ReporteFecha> listarConseccionario() {
		return reporteService.listarReporteFecha();
	}
}
