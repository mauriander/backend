/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Educacion;
import com.ejemplo.SpringBoot.model.TipoEducacion;
import com.ejemplo.SpringBoot.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MAURICIO
 */
@Service
public class EducacionService implements IEducacionService{
     @Autowired
     EducacionRepository edRep;

    @Override
    public List<Educacion> verEducaciones() {
      return edRep.findAll();//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearEducacion(Educacion p) {
        edRep.save(p);//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarEducacion(Long id) {
        edRep.deleteById(id); //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Educacion buscarEducacion(Long id) {
       return edRep.findById(id).orElse(null); 
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


@Override
public void editarEducacion(Long id,Educacion p){
Educacion pnew=edRep.findById(id).orElse(null);
     
      if(pnew!=null){
            pnew.setNombre(p.getNombre());
pnew.setInstitucion(p.getInstitucion());
            pnew.setNivel(p.getNivel());
            pnew.setFechafin(p.getFechafin());
            pnew.setFechaini(p.getFechaini());
           // pnew.setPersonaEducacionCollection(p.getPersonaEducacionCollection());
           // pnew.setTipoeducacion(p.getTipoeducacion());

            
            edRep.save(pnew);}
      else{
      edRep.save(p);}

}


}
