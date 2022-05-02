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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "persona")
public class Persona implements Serializable{

    
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    
   
    @JoinColumn(name = "LOCALIDAD_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Localidad localidad;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private Set<PersonaEducacion> personaEducacionCollection;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private Set<Experiencia> experienciaCollection;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private Set<Skill> skillCollection;
   
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
    private User user;

    public Persona(Long id, String nombre, String apellido, Localidad localidad, Set<PersonaEducacion> personaEducacionCollection, Set<Experiencia> experienciaCollection, Set<Skill> skillCollection, User user) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.localidad = localidad;
        this.personaEducacionCollection = personaEducacionCollection;
        this.experienciaCollection = experienciaCollection;
        this.skillCollection = skillCollection;
        this.user = user;
    }

   
    

    
    
    public Persona() {
    }
    
    
    
    
    
    
}
