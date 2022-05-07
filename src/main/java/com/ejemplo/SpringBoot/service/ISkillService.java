/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejemplo.SpringBoot.service;


import com.ejemplo.SpringBoot.model.Skill;
import java.util.List;

/**
 *
 * @author MAURICIO
 */
public interface ISkillService {
public List<Skill> verSkills();
    public void crearSkill(Skill p);
    public void borrarSkill(Long id);
    public Skill buscarSkill(Long id);
public void editarSkill(Long id,Skill p);
    
}
