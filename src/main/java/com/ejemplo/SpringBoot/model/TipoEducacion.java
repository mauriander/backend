/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "tipoeducacion")
@Getter
@Setter
public class TipoEducacion {
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
  
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.DATE)
    private Date fechaini;
    
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
     
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoeducacion")
    private Collection<Educacion> educacionCollection;

    public TipoEducacion(Long id, String nombre, Date fechaini, Date fechafin, Collection<Educacion> educacionCollection) {
        this.id = id;
        this.nombre = nombre;
        this.fechaini = fechaini;
        this.fechafin = fechafin;
        this.educacionCollection = educacionCollection;
    }

    
    
    
    public TipoEducacion() {
    }
    
    
}
