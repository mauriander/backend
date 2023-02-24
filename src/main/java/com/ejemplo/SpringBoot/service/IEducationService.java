/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Education;
import java.util.List;

/**
 *
 * @author MAURICIO
 */
public interface IEducationService {
      public List<Education> verEducations();
    public void crearEducation(Education p);
    public void borrarEducation(Long id);
    public Education buscarEducation(Long id);  
public void editarEducation (Long id,Education p);
    
}
