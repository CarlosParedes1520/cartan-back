package com.ideas.springboot.formulario.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ideas.springboot.formulario.app.model.Conversacion;
import com.ideas.springboot.formulario.app.model.Detalle;
import com.ideas.springboot.formulario.app.service.ConversacionService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/conversacion")
public class RestConversacionController {

	@Autowired
	private ConversacionService conServicio;

	// agregar conversacion
	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	public Conversacion registrarCliente(@RequestBody @Valid Conversacion conversacion) {

		return conServicio.crearConversacion(conversacion);
	}

	// Buscar conversacion por id
	@GetMapping("/find/{id}")
	public Conversacion buscarPorId(@PathVariable long id) {
		return conServicio.findById(id);
	}

	// Listar conversacion
	@GetMapping(path = "/list", produces = "application/json")
	public List<Conversacion> listarConversacion() {
		return conServicio.listarConversaciones();
	}

	// Modificar conversacion
	@PutMapping("/mod/{id}")
	public Conversacion updateConversacion(@RequestBody Conversacion request, @PathVariable long id) {
		return conServicio.modificarConversacion(request, id);
	}

	// Eliminar conversacion
	@DeleteMapping("/delete/{id}")
	public void borrarXid(@PathVariable long id) {
		conServicio.eliminarConversacionXid(id);
	}

	/*// listar conversacion paginador
	@GetMapping("/pagina/{numeroPagina}/{numRegistros}")
	public Page<Conversacion> obtenerPagina(@PathVariable int numeroPagina, @PathVariable int numRegistros) {
		return conServicio.obtenerPagina(numeroPagina, numRegistros);
	}*/
	
	// listar conversacion paginador
	@GetMapping("/pagina/{page}")
	public Page<Conversacion> obtenerPaginaDeta(@PathVariable int page) {
		Pageable pageable = PageRequest.of(page, 5);
		return conServicio.obtenerPaginaDetalles(pageable);
	}
	
//	@GetMapping("/listaDetalle/{id}")
//	public List<Detalle> listarDetallesConversacione(@PathVariable long id) {
//		return conServicio.listarDetallesConversacioneSS(id);
//	}
	
	@GetMapping("/listaDetalle/{page}/{id}")
	public Page<Conversacion> listarDetallesConversacione(@PathVariable int page, @PathVariable long id) {
		Pageable pageable = PageRequest.of(page, 2);
		return conServicio.listarDetallesConversacioneSS(pageable,id);
	}
	
//	@GetMapping("/listaDetalle/{id}")
//	public List<Object[]> listarDetallesConversacione(@PathVariable long id) {
//		return conServicio.listarDetallesConversacioneSS(id);
//	}
}
