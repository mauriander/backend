/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.model;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author MAURICIO
 * 
 * 
 * 
 */



@Entity
@Table(name = "acercade")
@Getter @Setter

    
  
    //@Basic(optional = false)
    
public class Acercade implements Serializable {
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;  
    
    
    public Acercade(Long id, String descripcion){
    this.id=id;
    this.descripcion=descripcion;
    }
    public Acercade(){}
    
    
}
