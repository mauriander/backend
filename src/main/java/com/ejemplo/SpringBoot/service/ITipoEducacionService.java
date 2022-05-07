/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.TipoEducacion;
import java.util.List;

/**
 *
 * @author MAURICIO
 */
public interface ITipoEducacionService {
    public List<TipoEducacion> verTipoEducaciones();
    public void crearTipoEducacion(TipoEducacion p);
    public void borrarTipoEducacion(Long id);
    public TipoEducacion buscarTipoEducacion(Long id);
public void editarTipoEducacion(Long id,TipoEducacion p);
    
}
