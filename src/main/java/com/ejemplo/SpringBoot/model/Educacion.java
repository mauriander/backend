/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collection;
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

/**
 *
 * @author MAURICIO
 */
@Entity
@Table(name = "educacion")
@Getter
@Setter
public class Educacion   {

    @Id  
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
   
     @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educacion")
    private Collection<PersonaEducacion> personaEducacionCollection;
    @JoinColumn(name = "TIPOEDUCACION_id",nullable = false)
    
    @ManyToOne(optional = false)
   private TipoEducacion tipoeducacion;

    public Educacion(Long id, String nombre, Collection<PersonaEducacion> personaEducacionCollection, TipoEducacion tipoeducacion) {
        this.id = id;
        this.nombre = nombre;
        this.personaEducacionCollection = personaEducacionCollection;
        this.tipoeducacion = tipoeducacion;
    }

    
   
    
    
    public Educacion() {
    }
    
}
