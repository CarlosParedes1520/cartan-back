package com.ideas.springboot.formulario.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ideas.springboot.formulario.app.model.Conversacion;
import com.ideas.springboot.formulario.app.model.ReporteFecha;
@Repository
public interface IReporte extends JpaRepository<ReporteFecha, Long>{

	// para reporte por rango fechas y nivel satisfaccion
//		@Query(value= "SELECT sc FROM Conseccionario sc "
//					+ "WHERE sc.fecha Between :desde AND :hasta AND sc.cliente.eliminado = true  AND sc.nivelSatisfaccion = :nivel "
//					+ "ORDER BY sc.cliente.usuario.nombre ASC ")
//		public List<ReporteFecha> findByFechasAndNivelSatisfaccionReporte (	@Param("desde") Date desde, 
//																					@Param("hasta") Date hasta, 
//																					@Param("nivel") String nombre);
	
}
