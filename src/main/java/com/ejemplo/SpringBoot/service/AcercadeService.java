/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Acercade;
import com.ejemplo.SpringBoot.repository.AcercadeRepository;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MAURICIO
 */
@Service
public class AcercadeService implements IAcercadeService  {
    @Autowired
            AcercadeRepository acdRep;
    @Override
    public List<Acercade> verAcercades() {
       return acdRep.findAll();
    }

    @Override
    public void crearAcercade(Acercade p) {
       acdRep.save(p);
    }

    @Override
    public void borrarAcercade(Long id) {
         acdRep.deleteById(id);
    }

    @Override
    public Acercade buscarAcercade (Long id) {
          return acdRep.findById(id).orElse(null);
    }
@Override
public void editarAcercade(Long id,Acercade p){
Acercade pnew=acdRep.findById(id).orElse(null);
     
      if(pnew!=null){
            
            pnew.setDescripcion(p.getDescripcion());
            

            
            
            acdRep.save(pnew);}
      else{
      acdRep.save(p);}

}
    
    
}
