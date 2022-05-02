/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Persona;
import com.ejemplo.SpringBoot.model.Proyecto;
import java.util.List;

/**
 *
 * @author MAURICIO
 */
public interface IProyectoService {
     public List<Proyecto> verProyectos();
    public void crearProyecto(Proyecto p);
    public void borrarProyecto(Long id);
    public Proyecto buscarProyecto(Long id);
 



}
