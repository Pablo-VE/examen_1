/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.proyectos.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.examen.proyectos.repositories.ITareaRepository;
import org.una.examen.proyectos.dto.TareaDTO;
import org.una.examen.proyectos.entities.Tarea;
import org.una.examen.proyectos.util.MapperUtils;
import org.una.examen.proyectos.util.ServiceConvertionHelper;
/**
 *
 * @author Pablo-VE
 */

@Service
public class TareaServiceImplementation implements ITareaService{
    @Autowired
    private ITareaRepository tareaRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<TareaDTO>> findByProyecto(Long proyecto) {
        return ServiceConvertionHelper.findList(tareaRepository.findByProyecto(proyecto), TareaDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<TareaDTO>> findAll() {
        return ServiceConvertionHelper.findList(tareaRepository.findAll(), TareaDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TareaDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(tareaRepository.findById(id), TareaDTO.class);
    }
    
    @Override
    @Transactional
    public TareaDTO create(TareaDTO tarea) {
        Tarea tar = MapperUtils.EntityFromDto(tarea, Tarea.class);
        tar = tareaRepository.save(tar);
        return MapperUtils.DtoFromEntity(tar, TareaDTO.class);
    }

    @Override
    @Transactional
    public Optional<TareaDTO> update(TareaDTO tarea, Long id) {
        if (tareaRepository.findById(id).isPresent()) {
            Tarea tar = MapperUtils.EntityFromDto(tarea, Tarea.class);
            tar = tareaRepository.save(tar);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(tar, TareaDTO.class));
        } else {
            return null;
        } 
    }
    
}
