/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author MAURICIO
 */

@Entity
@Table(name = "proyecto")
@Setter
@Getter

public class Proyecto {
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO) 
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    
    
    @Column(name = "url")
    private String url;
    
    @Column(name = "tipo_tecnologia")
    private String tipotec;
    
    @Column(name = "descripcion_proyecto")
    private String descripcion;
    
     @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
    private Collection<Experiencia> experienciaCollection;

    public Proyecto(Long id, String nombre, String url, String tipotec, String descripcion, Collection<Experiencia> experienciaCollection) {
        this.id = id;
        this.nombre = nombre;
        this.url = url;
        this.tipotec = tipotec;
        this.descripcion = descripcion;
        this.experienciaCollection = experienciaCollection;
    }

    

   
    
    public Proyecto() {
    } 
    

  /*  public Proyecto(Integer idPROYECTO, String nombreProyecto, String urlProyecto) {
        this.idPROYECTO = idPROYECTO;
        this.nombreProyecto = nombreProyecto;
        this.urlProyecto = urlProyecto;
    */
    
    
}
