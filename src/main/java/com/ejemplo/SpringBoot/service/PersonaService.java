/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Persona;
import com.ejemplo.SpringBoot.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MAURICIO
 */
@Service
public class PersonaService implements IPersonaService{
    
    
    
    @Autowired
    PersonaRepository perRep;
    
    @Override 
    public List<Persona> verPersonas() {
       return perRep.findAll();
    }

    @Override
    public void crearPersona(Persona p) {
        perRep.save(p);
    }

    @Override
    public void borrarPersona(Long id) {
        perRep.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
    return perRep.findById(id).orElse(null);
    }
    
    @Override
    public void editarPersona(Long id, Persona p) {
     Persona pnew=perRep.findById(id).orElse(null);
     //pregunto si no es nulo, entonces edito el existente
      if(pnew!=null){
            pnew.setNombre(p.getNombre());
            pnew.setApellido(p.getApellido());
            pnew.setDomicilio(p.getDomicilio());
            pnew.setFenac(p.getFenac());
            pnew.setUrlimage(p.getUrlimage());
            //continuar con cada atributo
            
            perRep.save(pnew);}
      else{//si es nulo, no exite entonces lo creo
          
     perRep.save(p);}
     

    }
}
