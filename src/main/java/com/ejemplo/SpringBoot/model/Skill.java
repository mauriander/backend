/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.model;

/**
 *
 * @author Mauricio Carlos
 */



import javax.persistence.Column;
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

 
@Entity
@Table(name = "skill")
 @Getter
 @Setter
public class Skill {
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
   
    @Column(name = "Nombre")
    private String nombre;
    
    @Column(name = "Valor")
    private Integer valor;
   
    @JoinColumns({
        @JoinColumn(name = "PERSONA_id", referencedColumnName = "id",nullable = false)
       ,@JoinColumn(name = "PERSONA_LOCALIDAD_id", referencedColumnName = "LOCALIDAD_id", nullable = false)
    })
    @ManyToOne(optional = false)
    private Persona persona;

    public Skill(Long id, String nombre, Integer valor, Persona persona) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.persona = persona;
    }

   

   
     public Skill() {
    }
    
    
}
