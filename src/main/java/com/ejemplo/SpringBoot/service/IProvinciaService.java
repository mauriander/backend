/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Provincia;
import java.util.List;

/**
 *
 * @author MAURICIO
 */
public interface IProvinciaService {
    
    //Aca nombro las funciones....
    public List<Provincia> verProvincias();
    public void crearProvincia(Provincia pro);
    public void borrarProvincia(Long id);
    public Provincia buscarProvincia(Long id);
    public void editarProvincia(Long id,Provincia p);

}
