/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Experiencia;
import com.ejemplo.SpringBoot.repository.ExperienciaRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MAURICIO
 */
@Service
public class ExperienciaService implements IExperienciaService{
@Autowired
ExperienciaRepository expRep;
    @Override
    public List<Experiencia> verExperiencias() {
       return expRep.findAll();
    }

    @Override
    public void crearExperiencia(Experiencia p) {
       expRep.save(p);
    }

    @Override
    public void borrarExperiencia(Long id) {
         expRep.deleteById(id);
    }

    @Override
    public Experiencia buscarExperiencia(Long id) {
          return expRep.findById(id).orElse(null);
    }
@Override
public void editarExperiencia(Long id,Experiencia p){
Experiencia pnew=expRep.findById(id).orElse(null);
     
      if(pnew!=null){
            pnew.setNombre(p.getNombre());
            pnew.setDescripcion(p.getDescripcion());
            pnew.setFechaFin(p.getFechaFin());
pnew.setFechaIni(p.getFechaIni());
//pnew.setPersona(p.getPersona());
//pnew.setProyecto(p.getProyecto());
            
            
            expRep.save(pnew);}
      else{
      expRep.save(p);}

}
   
    
}
