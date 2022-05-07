/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.PersonaEducacion;

import java.util.List;

/**
 *
 * @author Mauricio Carlos
 */
public interface IPersonaEducacionService {
    public List<PersonaEducacion> verPersonaEducaciones();
    public void crearPersonaEducacion(PersonaEducacion p);
    public void borrarPersonaEducacion(Long id);
    public PersonaEducacion buscarPersonaEducacion(Long id);
}
