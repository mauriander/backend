/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Localidad;
import com.ejemplo.SpringBoot.model.Provincia;
import com.ejemplo.SpringBoot.repository.LocalidadRepository;
import com.ejemplo.SpringBoot.repository.ProvinciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MAURICIO
 */
@Service
public class LocalidadService implements ILocalidadService{
 
   

    
    @Autowired
    LocalidadRepository locRep;
    
    
    @Override
    public List<Localidad> verLocalidades() {
       
    return locRep.findAll();
    
    
    }

    @Override
    public void crearLocalidad(Localidad p) {
        locRep.save(p);
    }

    @Override
    public void borrarLocalidad(Long id) {
        locRep.deleteById(id);
    }

    @Override
    public Localidad buscarLocalidad(Long id) {
        return locRep.findById(id).orElse(null);
    }

 @Override
public void editarLocalidad(Long id,Localidad p){
        Localidad pnew=locRep.findById(id).orElse(null);

     
      if(pnew!=null){
            pnew.setNombre(p.getNombre());
            pnew.setCp(p.getCp());
//pnew.setPersonaCollection(p.getPersonaCollection());
pnew.setProvince(p.getProvince());
            locRep.save(pnew);}
      else{
      locRep.save(p);}

}
    
}
