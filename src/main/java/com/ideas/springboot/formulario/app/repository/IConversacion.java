package com.ideas.springboot.formulario.app.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ideas.springboot.formulario.app.model.Conversacion;
import com.ideas.springboot.formulario.app.model.Detalle;

@Repository
public interface IConversacion extends JpaRepository<Conversacion, Long> {

	// lista de de clientes que contengan un seguimiento usando query
//	@Query(value= "SELECT c FROM Cliente c, SeguimientoCliente sc "
//				+ "WHERE sc.cliente.id = c.id AND c.eliminado = 1 "
//				+ "GROUP BY (c.id)" 
//				+ "ORDER BY c.usuario.nombre ASC ")
//	public Page<Cliente> findBySegumientosCliente(Pageable pageable);
//	
	
	// con sql nativo
//	@Query(value = " select * from t_conversacion tc inner join t_conversacion_detalle tcd on  tc.id_conversacional = id_conversacion where tc.id_conversacional =:id ", nativeQuery = true)
//	List<Detalle> listarDetallesConversaciones(@Param("id") long id);
	
	//jpp query para mostrar registros de tablas seleccionadas mostrando los datos de una de las tablas "Detalle"
//	@Query("SELECT cd FROM Conversacion c INNER JOIN c.detalles cd WHERE c.id = :id")
//    List<Detalle> listarDetallesConversaciones(Pageable pageable,@Param("id") Long id);
	
	@Query("SELECT cd FROM Conversacion c INNER JOIN c.detalles cd WHERE c.id = :id")
	Page<Conversacion> listarDetallesConversaciones(Pageable pageable,@Param("id") Long id);

//	 @Query("SELECT cd FROM Detalle cd ")
//	    List<Detalle> listarDetallesConversaciones(@Param("id") Long id);
	
	
//	@Query("SELECT c, cd FROM Conversacion c INNER JOIN c.detalles cd WHERE c.id = :id")
//	List<Object[]> listarDetallesConversaciones(@Param("id") Long id);
}
