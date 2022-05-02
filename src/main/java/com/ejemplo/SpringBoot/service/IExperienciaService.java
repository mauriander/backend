/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Experiencia;
import java.util.List;

/**
 *
 * @author MAURICIO
 */
public interface IExperienciaService {
     public List<Experiencia> verExperiencias();
    public void crearExperiencia(Experiencia p);
    public void borrarExperiencia(Long id);
    public Experiencia buscarExperiencia(Long id);  
}
