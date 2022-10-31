/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Localidad;
import java.util.List;

/**
 *
 * @author MAURICIO
 */
public interface ILocalidadService {
    public List<Localidad> verLocalidades();
    public void crearLocalidad(Localidad p);
    public void borrarLocalidad(Long id);
    public Localidad buscarLocalidad(Long id); 
    
public void editarLocalidad(Long id,Localidad p); 
}
