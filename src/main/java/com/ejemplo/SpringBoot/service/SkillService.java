/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.service;


import com.ejemplo.SpringBoot.model.Skill;

import com.ejemplo.SpringBoot.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MAURICIO
 */
@Service
public class SkillService implements ISkillService{
    @Autowired
    SkillRepository skiRep;

@Override
    public List<Skill> verSkills() {
       
    return skiRep.findAll();
    
    
    }

    @Override
    public void crearSkill(Skill p) {
        skiRep.save(p);
    }

    @Override
    public void borrarSkill(Long id) {
        skiRep.deleteById(id);
    }

    @Override
    public Skill buscarSkill(Long id) {
        return skiRep.findById(id).orElse(null);
    }

@Override
 public void editarSkill(Long id,Skill p){
Skill pnew=skiRep.findById(id).orElse(null);
     
      if(pnew!=null){
            pnew.setNombre(p.getNombre());
            pnew.setValor(p.getValor());
            
            skiRep.save(pnew);}
      else{
      skiRep.save(p);}

}
 @Override
    public void editarSkill(Skill p) {
        skiRep.save(p);
       
    }
}
