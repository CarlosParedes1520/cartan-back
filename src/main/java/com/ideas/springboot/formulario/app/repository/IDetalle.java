package com.ideas.springboot.formulario.app.repository;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ideas.springboot.formulario.app.model.Detalle;

@ComponentScan({ "com.yourpkg.*" })
@Repository
public interface IDetalle  extends JpaRepository<Detalle, Long> {

	
	@Query("SELECT cd FROM Conversacion c INNER JOIN c.detalles cd WHERE c.id = :id AND cd.codigo = :codigo")
	List<Detalle> listarDetalles(@Param("id") Long id, @Param("codigo") Long codigo);

	//Detalle listarDetalles(Long id, Long codigo);


}
