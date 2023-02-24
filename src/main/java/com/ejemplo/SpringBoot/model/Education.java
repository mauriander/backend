/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author MAURICIO
 */

@Entity
@Table(name = "education")
@Getter
@Setter
public class Education implements Serializable  {
     @Id  
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "nivel")
    private String nivel;
    
     @Column(name = "institucion")
    private String institucion;
    
    @Column(name = "fechaini")
    @Temporal (TemporalType.DATE)
    private Date fechaini;
    
    @Column(name = "fechafin")
    @Temporal (TemporalType.DATE)
     private Date fechafin;
   
     @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educacion")
    private Collection<PersonaEducacion> personaEducacionCollection;
    /*
     @JoinColumn(name = "TIPOEDUCACION_id",nullable = false)   
    @ManyToOne(optional = false)
   private TipoEducacion tipoeducacion;
*/
    
    /*
    public Educacion(Long id, String nombre, Collection<PersonaEducacion> personaEducacionCollection, TipoEducacion tipoeducacion) {
        this.id = id;
        this.nombre = nombre;
        this.personaEducacionCollection = personaEducacionCollection;
        this.tipoeducacion = tipoeducacion;
    }*/
     
    

    public Education(Long id, String nombre, String nivel, String institucion, Date fechaini, Date fechafin, Collection<PersonaEducacion> personaEducacionCollection) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.institucion = institucion;
        this.fechaini = fechaini;
        this.fechafin = fechafin;
        this.personaEducacionCollection = personaEducacionCollection;
    }

   
    
    

    
   
    
    
    public Education() {
    }
    
}
