/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.proyectos.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.una.examen.proyectos.util.MapperUtils;
import org.una.examen.proyectos.util.ServiceConvertionHelper;
import org.una.examen.proyectos.dto.ProyectoDTO;
import org.una.examen.proyectos.entities.Proyecto;
import org.una.examen.proyectos.repositories.IProyectoRepository;

/**
 *
 * @author Pablo-VE
 */
public class ProyectoServiceImplementation implements IProyectoService{
    @Autowired
    private IProyectoRepository proyectoRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<ProyectoDTO>> findByNombre(String nombre) {
        return ServiceConvertionHelper.findList(proyectoRepository.findByNombreContainingIgnoreCase(nombre), ProyectoDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<ProyectoDTO>> findByResponsable(String responsable) {
        return ServiceConvertionHelper.findList(proyectoRepository.findByResponsableContainingIgnoreCase(responsable), ProyectoDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<ProyectoDTO>> findAll() {
        return ServiceConvertionHelper.findList(proyectoRepository.findAll(), ProyectoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProyectoDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(proyectoRepository.findById(id), ProyectoDTO.class);
    }
    
    @Override
    @Transactional
    public ProyectoDTO create(ProyectoDTO proyecto) {
        Proyecto pro = MapperUtils.EntityFromDto(proyecto, Proyecto.class);
        pro = proyectoRepository.save(pro);
        return MapperUtils.DtoFromEntity(pro, ProyectoDTO.class);
    }

    @Override
    @Transactional
    public Optional<ProyectoDTO> update(ProyectoDTO proyecto, Long id) {
        if (proyectoRepository.findById(id).isPresent()) {
            Proyecto pro = MapperUtils.EntityFromDto(proyecto, Proyecto.class);
            pro = proyectoRepository.save(pro);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(pro, ProyectoDTO.class));
        } else {
            return null;
        } 
    }
}
