/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.model;
/*
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
*/
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author MAURICIO
 */
/*
        @Entity
@Table(name = "provincia")
@NamedQueries({
    @NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p"),
    @NamedQuery(name = "Provincia.findByIdProvincia", query = "SELECT p FROM Provincia p WHERE p.idProvincia = :idProvincia"),
    @NamedQuery(name = "Provincia.findByNombreProvincia", query = "SELECT p FROM Provincia p WHERE p.nombreProvincia = :nombreProvincia")})

public class Provincia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id  
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column(name = "idProvincia")
    private Integer idProvincia;
    @Column(name = "nombre_provincia")
    private String nombreProvincia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provincia")
    private Collection<Localidad> localidadCollection;

    public Provincia() {
    }

    public Provincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public Collection<Localidad> getLocalidadCollection() {
        return localidadCollection;
    }

    public void setLocalidadCollection(Collection<Localidad> localidadCollection) {
        this.localidadCollection = localidadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProvincia != null ? idProvincia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincia)) {
            return false;
        }
        Provincia other = (Provincia) object;
        if ((this.idProvincia == null && other.idProvincia != null) || (this.idProvincia != null && !this.idProvincia.equals(other.idProvincia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.Provincia[ idProvincia=" + idProvincia + " ]";
    }
    
}
*/



@Entity
@Table(name = "provincia")
@Getter @Setter
/*@NamedQueries({
    @NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p"),
    @NamedQuery(name = "Provincia.findByIdProvincia", query = "SELECT p FROM Provincia p WHERE p.idProvincia = :idProvincia"),
    @NamedQuery(name = "Provincia.findByNombreProvincia", query = "SELECT p FROM Provincia p WHERE p.nombreProvincia = :nombreProvincia")})*/
public class Provincia implements Serializable {
   
    //@Id
    //@GeneratedValue (strategy=GenerationType.AUTO)
    //private int id;
    //private String nombre;
    
    
    
    
    
    @Id  
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
    
   
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "province")
    private Set<Localidad> localidadCollection;

    public Provincia(Long id, String nombre, Set<Localidad> localidadCollection) {
        this.id = id;
        this.nombre = nombre;
        this.localidadCollection = localidadCollection;
    }

   
    
    public Provincia() {
    }

 
 @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
   
    
}