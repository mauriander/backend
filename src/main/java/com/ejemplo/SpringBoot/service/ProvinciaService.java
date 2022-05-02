/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Provincia;
import com.ejemplo.SpringBoot.repository.ProvinciaRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




/**
 *
 * @author MAURICIO
 */
@Service
public class ProvinciaService implements IProvinciaService {

    
    //no conectamos con JPA con el repository
    @Autowired
    public ProvinciaRepository provRepo;
    
    @Override
    public List<Provincia> verProvincias() {
        return provRepo.findAll();
    }

    @Override
    public void crearProvincia(Provincia pro) {
        provRepo.save(pro);
    }

    @Override
    public void borrarProvincia(Long id) {
        provRepo.deleteById(id);
    }

    @Override
    public Provincia buscarProvincia(Long id) {
        return provRepo.findById(id).orElse(null);
    }
    
}
