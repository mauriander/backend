/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Proyecto;
import com.ejemplo.SpringBoot.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mauricio Carlos
 */
@Service
public class ProyectoService implements IProyectoService{
    @Autowired
    ProyectoRepository proRep;

@Override
    public List<Proyecto> verProyectos() {
       
    return proRep.findAll();
    
    
    }

    @Override
    public void crearProyecto(Proyecto p) {
        proRep.save(p);
    }

    @Override
    public void borrarProyecto(Long id) {
        proRep.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Long id) {
        return proRep.findById(id).orElse(null);
    }

 @Override
 public void editarProyecto(Long id,Proyecto p){
Proyecto pnew=proRep.findById(id).orElse(null);
     
      if(pnew!=null){
            pnew.setNombre(p.getNombre());

            pnew.setDescripcion(p.getDescripcion());
            pnew.setTipotec(p.getTipotec());
            pnew.setUrl(p.getUrl());
            //pnew.setNombre(p.getNombre());

            proRep.save(pnew);}
      else{
      proRep.save(p);}

}


}
