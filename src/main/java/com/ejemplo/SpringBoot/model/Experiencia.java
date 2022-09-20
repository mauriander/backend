/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mauricio Carlos
 */

@Entity
@Table(name = "experiencia")
@Getter @Setter
public class Experiencia {
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    //@Basic(optional = false)
    
    

    @Column(name = "fecha_ini")
    @Temporal (TemporalType.DATE)
    private Date fechaIni;

//@JsonFormat(pattern="yyyy-MM")
    @Column(name = "fecha_fin")
    @Temporal (TemporalType.DATE)
    private Date fechaFin;
    
     @Column(name = "actual")
     private String actual;
    
    

    @JoinColumn(name = "PERSONA_id", referencedColumnName = "id", nullable = false)
     
    @ManyToOne//(optional = false)
    private Persona persona;
/*
    @JoinColumn(name = "PROYECTO_id", referencedColumnName = "id", nullable = false)
    @ManyToOne//(optional = false)
    private Proyecto proyecto;

    public Experiencia(Long id, String nombre, String descripcion, Date fechaIni, Date fechaFin, Persona persona, Proyecto proyecto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.persona = persona;
        this.proyecto = proyecto;
    }
*/
/*
    public Experiencia(Long id, String nombre, String descripcion, Date fechaIni, Date fechaFin, Persona persona) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.persona = persona;
    }
*/
    public Experiencia(Long id, String nombre, String descripcion, Date fechaIni, Date fechaFin, String actual, Persona persona) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.actual = actual;
        this.persona = persona;
    }
    

    
    
    public Experiencia() {
    }


}
