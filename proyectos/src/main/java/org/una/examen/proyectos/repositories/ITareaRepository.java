/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.proyectos.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.examen.proyectos.entities.Tarea;

/**
 *
 * @author Pablo-VE
 */
public interface ITareaRepository extends JpaRepository<Tarea, Long>{
    @Query("SELECT t FROM Tarea t LEFT JOIN t.proyecto p WHERE p.id = :proyectoID")
    public List<Tarea> findByProyecto(@Param("proyectoID")Long proyecto);
    
}
