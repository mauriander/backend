/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "localidad")
@Getter @Setter

public class Localidad implements Serializable  {
        
    @Id  
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "cp")
    private int cp;
   
        
    @Column(name = "nombre")
    private String nombre;
   // @Basic(optional = false)
   
   @JsonIgnore
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "localidad")
    private Set<Persona> personaCollection;
   
       
   @ManyToOne
   @JoinColumn(name = "PROVINCIA_id")
    private Provincia province;

    public Localidad(Long id, int cp, String nombre, Set<Persona> personaCollection,  Provincia province) {
        this.id = id;
        this.cp = cp;
        this.nombre = nombre;
        this.personaCollection = personaCollection;
        
        this.province = province;
    }

    

   

  
    
    
     public Localidad() {
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
 

   
    
}
