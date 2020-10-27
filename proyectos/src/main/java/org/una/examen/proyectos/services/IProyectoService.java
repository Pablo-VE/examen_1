/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.proyectos.services;

import java.util.List;
import java.util.Optional;
import org.una.examen.proyectos.dto.ProyectoDTO;

/**
 *
 * @author Pablo-VE
 */
public interface IProyectoService {
    public Optional<List<ProyectoDTO>> findByNombre(String nombre);
    public Optional<List<ProyectoDTO>> findByResponsable(String responsable);
    public Optional<List<ProyectoDTO>> findAll();
    public Optional<ProyectoDTO> findById(Long id);
    public ProyectoDTO create(ProyectoDTO proyecto);
    public Optional<ProyectoDTO> update(ProyectoDTO proyecto, Long id);
    
}
