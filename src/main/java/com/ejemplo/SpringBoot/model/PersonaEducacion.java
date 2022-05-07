/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mauricio Carlos
 */

@Entity
@Table(name = "persona_educacion")
@Getter
@Setter
public class PersonaEducacion implements Serializable{
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column(name = "id")
   private Long id;
    
    @JoinColumns({
        @JoinColumn(name = "EDUCACION_id", referencedColumnName = "id", nullable = false),
        @JoinColumn(name = "EDUCACION_TIPOEDUCACION_id", referencedColumnName = "TIPOEDUCACION_id", nullable = false)})
    
    @ManyToOne(optional = false)
    private Educacion educacion;
    @JoinColumns({
        @JoinColumn(name = "PERSONA_id", referencedColumnName = "id", nullable = false),
        @JoinColumn(name = "PERSONA_LOCALIDAD_id", referencedColumnName = "LOCALIDAD_id", nullable = false)})
    
    @ManyToOne(optional = false)
    private Persona persona;

    public PersonaEducacion(Long id, Educacion educacion, Persona persona) {
        this.id = id;
        this.educacion = educacion;
        this.persona = persona;
    }
    
    
    

    public PersonaEducacion() {
    }
}
