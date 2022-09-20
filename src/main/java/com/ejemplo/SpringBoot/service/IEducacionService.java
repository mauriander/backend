/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Educacion;

import java.util.List;

/**
 *
 * @author MAURICIO
 */
public interface IEducacionService {
    public List<Educacion> verEducaciones();
    public void crearEducacion(Educacion p);
    public void borrarEducacion(Long id);
    public Educacion buscarEducacion(Long id);
    public void editarEducacion(Long id,Educacion p);

    /**
     *
     * @param p
     */
    public void editarEducacion(Educacion p);
}
