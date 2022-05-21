/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    

     
    @Temporal (TemporalType.DATE)
    private Date fenac;
     

       
    private String urlimage;
    private String domicilio;
    
     
    
   
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private Set<Proyecto> proyectoCollection;
   /*
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
    private User user;
*/

/*
    public Persona(Long id, String nombre, String apellido, Date fenac, String urlimage, String domicilio, Localidad localidad, Set<PersonaEducacion> personaEducacionCollection, Set<Experiencia> experienciaCollection, Set<Skill> skillCollection, Set<Proyecto> proyectoCollection, User user) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fenac = fenac;
        this.urlimage = urlimage;
        this.domicilio = domicilio;
        this.localidad = localidad;
        this.personaEducacionCollection = personaEducacionCollection;
        this.experienciaCollection = experienciaCollection;
        this.skillCollection = skillCollection;
        this.proyectoCollection = proyectoCollection;
        this.user = user;
    }
*/

    public Persona(Long id, String nombre, String apellido, Date fenac, String urlimage, String domicilio, Localidad localidad, Set<PersonaEducacion> personaEducacionCollection, Set<Experiencia> experienciaCollection, Set<Skill> skillCollection, Set<Proyecto> proyectoCollection) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fenac = fenac;
        this.urlimage = urlimage;
        this.domicilio = domicilio;
        this.localidad = localidad;
        this.personaEducacionCollection = personaEducacionCollection;
        this.experienciaCollection = experienciaCollection;
        this.skillCollection = skillCollection;
        this.proyectoCollection = proyectoCollection;
    }

    
    
    public Persona() {
    }
    
    
    
    
    
    
}
