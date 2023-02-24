/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Education;
import com.ejemplo.SpringBoot.model.Experiencia;
import com.ejemplo.SpringBoot.repository.EducationRepository;
import com.ejemplo.SpringBoot.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MAURICIO
 */
@Service
public class EducationService implements IEducationService{
@Autowired
EducationRepository edRep;
    @Override
    public List<Education> verEducations() {
        return edRep.findAll();
    }

    @Override
    public void crearEducation(Education p) {
      edRep.save(p);
    }

    @Override
    public void borrarEducation(Long id) {
           edRep.deleteById(id);
    }

    @Override
    public Education buscarEducation(Long id) {
        return edRep.findById(id).orElse(null);
    }

    @Override
    public void editarEducation(Long id, Education p) {
       Education pnew=edRep.findById(id).orElse(null);
     
      if(pnew!=null){
            pnew.setNombre(p.getNombre());
            pnew.setInstitucion(p.getInstitucion());
            pnew.setNivel(p.getNivel());
            pnew.setFechafin(p.getFechafin());
            pnew.setFechaini(p.getFechaini());
//pnew.setPersona(p.getPersona());
//pnew.setProyecto(p.getProyecto());
            
            
            edRep.save(pnew);}
      else{
      edRep.save(p);}

   
    }
    
}
