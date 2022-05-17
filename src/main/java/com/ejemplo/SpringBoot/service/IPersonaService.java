/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Persona;
import java.util.List;

/**
 *
 * @author MAURICIO
 */
public interface IPersonaService {
    public List<Persona> verPersonas();
    public void crearPersona(Persona p);
    public void borrarPersona(Long id);
    public Persona buscarPersona(Long id);
    public void editarPersona(Long id, Persona p);
    
}
