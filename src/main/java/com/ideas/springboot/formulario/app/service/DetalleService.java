package com.ideas.springboot.formulario.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ideas.springboot.formulario.app.model.Conversacion;
import com.ideas.springboot.formulario.app.model.Detalle;
import com.ideas.springboot.formulario.app.repository.IDetalle;

@Service
public class DetalleService {

	@Autowired(required = false)
	private IDetalle repo;

	// Servicio para crear Detalle
	public Detalle crearDetalle(Detalle conversacion) {
		return repo.save(conversacion);
	}

	// Servicio para buscar Detalle
	public List<Detalle> buscarDetalleXid(Long id, Long codigo) {
		return repo.listarDetalles(id, codigo);
	}
	
	
	// Servicio para buscar Detalle
	public Detalle buscarDetalleXid2(Long id) {
		return repo.findById(id).orElse(null);
	}

	// Servicio para modificar  Detalle
	public void modificarDetalle(Detalle request, Long id) {
		Detalle det = repo.findById(id).get();

		det.setCodigo(request.getCodigo());
		det.setRol(request.getRol());
		det.setMensaje(request.getMensaje());
		det.setPrompts(request.getPrompts());
		det.setFecha(request.getFecha());
		repo.save(det);
	}

	// Servicio para eliminar  Detalle
	public void eliminarDetalleXid(long id) {
		repo.deleteById(id);
	}

	// Servicio para listar  Detalle
	public List<Detalle> listarDetalle() {

		return repo.findAll();
	}

	// regresa una lista paginable de detalles 
	public Page<Detalle> obtenerPagina(int numeroPagina, int tamanoPagina) {
		Pageable pageable = PageRequest.of(numeroPagina, tamanoPagina);
		return repo.findAll(pageable);
	}
	
	/*// regresa un 
	@Transactional(readOnly = true)
	public Page<Conversacion> obtenerClientesSegumientos(int id) {
		return repo.istarDetallesConversacio;
	}*/
	
}
