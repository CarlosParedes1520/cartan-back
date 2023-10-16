package com.ideas.springboot.formulario.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
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
import com.ideas.springboot.formulario.app.service.DetalleService;

@RestController
@CrossOrigin("*")
@RequestMapping("/detalle")
public class RestDetalleController {

	@Autowired
	private DetalleService detServicio;

	// agregar detalle
	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	public Detalle registrarDetalle(@Validated @RequestBody Detalle detalle) {
		return detServicio.crearDetalle(detalle);
	}

	// Buscar detalle por id
	@GetMapping("/find/{id}/{codigo}")
	public List<Detalle> buscarPorid(@PathVariable long id, @PathVariable long codigo) {

		System.out.println(id);
		return detServicio.buscarDetalleXid(id,codigo);
	}
	
	
	// Buscar detalle por id
	@GetMapping("/find/{id}")
	public Detalle buscarPorId(@PathVariable long id) {

		return detServicio.buscarDetalleXid2(id);
	}
	

	// Listar detalle
	@GetMapping(path = "/list", produces = "application/json")
	public List<Detalle> listarDetalles() {
		return detServicio.listarDetalle();
	}

	// modificar detalle
	@PutMapping("/mod/{id}")
	public void modificarDetalle(@RequestBody Detalle request, @PathVariable long id) {
		detServicio.modificarDetalle(request, id);
	}

	// eliminar detalle
	@DeleteMapping("/delete/{id}")
	public void borrarXid(@PathVariable long id) {
		detServicio.eliminarDetalleXid(id);
	}

	// listar conversacion paginador
	@GetMapping("/pagina/{numeroPagina}/{tamanoPagina}")
	public Page<Detalle> obtenerPagina(@PathVariable int numeroPagina, @PathVariable int tamanoPagina) {
		return detServicio.obtenerPagina(numeroPagina, tamanoPagina);
	}

}
