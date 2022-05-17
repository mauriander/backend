/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.PersonaEducacion;
import com.ejemplo.SpringBoot.repository.PersonaEducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mauricio Carlos
 */
@Service
public class PersonaEducacionService implements IPersonaEducacionService {
     @Autowired
     PersonaEducacionRepository pedRep;
    @Override
    public List<PersonaEducacion> verPersonaEducaciones() {
       return pedRep.findAll();// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearPersonaEducacion(PersonaEducacion p) {
        pedRep.save(p);// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarPersonaEducacion(Long id) {
      pedRep.deleteById(id); //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonaEducacion buscarPersonaEducacion(Long id) {
       return pedRep.findById(id).orElse(null);//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


}
