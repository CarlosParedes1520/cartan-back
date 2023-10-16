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
import com.ideas.springboot.formulario.app.repository.IConversacion;

@Service
public class ConversacionService {

	@Autowired
	private IConversacion repo;

	// Servicio para crear Conversacion
	public Conversacion crearConversacion(Conversacion conversacion) {
		return repo.save(conversacion);
	}

	// Servicio para buscar Conversacion
	public Conversacion findById(long id) {
		return repo.findById(id).orElse(null);
	}

	// Servicio para crear Conversacion
	/*public Conversacion buscarConversacionXid(long id) {
		return repo.findById(id).orElse(null);
	}*/

	// Servicio para eliminar Conversacion
	public void eliminarConversacionXid(long id) {
		repo.deleteById(id);
	}

	// Servicio para Listar Conversacion
	public List<Conversacion> listarConversaciones() {
		return repo.findAll();
	}

	// Servicio para modificar Conversacion
	public Conversacion modificarConversacion(Conversacion request, long id) {
		Conversacion con = repo.findById(id).get();
		con.setIdentificador(request.getIdentificador());
		con.setSistema(request.getSistema());
		con.setFecha(request.getFecha());

		return repo.save(con);

	}

	// regresa una lista paginable de conversacion 
	public Page<Conversacion> obtenerPagina(int numeroPagina, int numRegistros) {
		Pageable pageable = PageRequest.of(numeroPagina, numRegistros);
		return repo.findAll(pageable);
	}
	
	// regresa una lista paginable de detalles 
	public Page<Conversacion> obtenerPaginaDetalles(int numeroPagina, int numRegistros) {
		Pageable pageable = PageRequest.of(numeroPagina, numRegistros);
		return repo.findAll(pageable);
	}
	
	// regresa una lista paginable de detalles 
	public Page<Conversacion> obtenerPaginaDetalles(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	
//	@Transactional(readOnly = true)
//	public Page<Cliente> obtenerClientesSegumientos(Pageable pageable) {
//		return clienteRepo.findBySegumientosCliente(pageable);
//	}
	
	// regresa un 
//	@Transactional(readOnly = true)
//	public List<Detalle> listarDetallesConversacioneSS(long id) {
//		return repo.listarDetallesConversaciones(id);
//	}
	//	@Transactional(readOnly = true)
	public Page<Conversacion> listarDetallesConversacioneSS(Pageable pageable, long id) {
		return repo.listarDetallesConversaciones(pageable, id);
	}
	
	// regresa un 
//	@Transactional(readOnly = true)
//	public List<Object[]> listarDetallesConversacioneSS(long id) {
//		return repo.listarDetallesConversaciones(id);
//	}
}
