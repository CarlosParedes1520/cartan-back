package com.ideas.springboot.formulario.app.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ideas.springboot.formulario.app.DTO.ConseccionarioDTO;
import com.ideas.springboot.formulario.app.entity.ConseccionarioEntity;
import com.ideas.springboot.formulario.app.model.Conseccionario;



public interface IConseccionario extends JpaRepository<Conseccionario, Long>{

	@Query("SELECT c FROM Conseccionario c WHERE c.conNomEmpresa = :con_nom_empresa")
	List<Conseccionario> getConseccionarioByNombre(String con_nom_empresa);
	

	@Query("SELECT DISTINCT c.conNomEmpresa FROM Conseccionario c")
	List<String> getConseccionarioActuales();
	
	// para reporte por rango fechas 

	@Query("SELECT c FROM Conseccionario c WHERE c.conFechaVenta BETWEEN :desde AND CURRENT_TIMESTAMP ORDER BY c.conFechaVenta DESC")
	public List<Conseccionario> findByFechasVenta( LocalDateTime desde);
	


	@Query("SELECT c.conNomEmpresa, SUM(c.conCantidad) FROM Conseccionario c GROUP BY c.conNomEmpresa ORDER BY c.conNomEmpresa ASC")
	List<Object[]> getConseccionarioCantidad();
	
	//@Query (value = "select c from Cliente c where c.persona.cedulaPersona = ?1")
	//@Query("SELECT DISTINCT c.con_nom_almacen FROM Conseccionario c  WHERE c.con_nom_almacen = :con_nom_almacen")
	@Query(value = "select DISTINCT c.conNomAlmacen, c.conNomEmpresa from Conseccionario c  where c.conNomEmpresa = :conNomEmpresa")
	 List<Object[]> getConseccionarioAlmacen(String conNomEmpresa);
	
	 
	 List<ConseccionarioDTO> findDistinctByConNomEmpresaIgnoreCaseContaining(String con_nom_almacen);
	 
	 @Query("SELECT c FROM Conseccionario c ORDER BY c.id DESC")
	 public List<Conseccionario> findByOrdenFecha( );
	 
	 
	 //List<ConseccionarioDTO> findByConFechaVenta(LocalDateTime con_fecha_venta);
	 
	 
	List<Conseccionario> findDistinctByConNomEmpresa(String con_nom);
	
	List<ConseccionarioDTO> findByConFechaVentaAfter(LocalDateTime fecha);
	 
	 
	 
	 
	 
	
}
