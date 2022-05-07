/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Skill;
import com.ejemplo.SpringBoot.model.TipoEducacion;

import com.ejemplo.SpringBoot.repository.TipoEducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MAURICIO
 */
@Service
public class TipoEducacionService implements ITipoEducacionService{
      @Autowired
    TipoEducacionRepository tedRep;


    @Override
    public List<TipoEducacion> verTipoEducaciones() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return tedRep.findAll();
    }

    @Override
    public void crearTipoEducacion(TipoEducacion p) {
          tedRep.save(p);//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarTipoEducacion(Long id) {
       tedRep.deleteById(id); //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoEducacion buscarTipoEducacion(Long id) {
        return tedRep.findById(id).orElse(null); 
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
 public void editarTipoEducacion(Long id,TipoEducacion p){
TipoEducacion pnew=tedRep.findById(id).orElse(null);
     
      if(pnew!=null){
            pnew.setNombre(p.getNombre());
            pnew.setFechafin(p.getFechafin());
            pnew.setFechaini(p.getFechaini());
            //pnew.setEducacionCollection(p.getEducacionCollection());
            
            tedRep.save(pnew);}
      else{
      tedRep.save(p);}

}
}
