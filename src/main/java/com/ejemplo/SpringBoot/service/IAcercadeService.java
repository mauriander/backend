/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Acercade;

import java.util.List;

/**
 *
 * @author MAURICIO
 */
public interface IAcercadeService {
      public List<Acercade> verAcercades();
    public void crearAcercade(Acercade p);
    public void borrarAcercade(Long id);
    public Acercade buscarAcercade(Long id);
    public void editarAcercade(Long id,Acercade p);

    /**
     *
     * @param p
     */
    
}