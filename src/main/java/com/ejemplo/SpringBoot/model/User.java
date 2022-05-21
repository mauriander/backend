/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.model;


import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

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
@Table(name = "user")
@Getter
@Setter
public class User {

   
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "username")
    private String username;
   
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "token")
    private String token;
    
 //   @Column(name = "create_time")
  //  @Temporal(TemporalType.TIMESTAMP)
  //  private Date createTime;
   
    
    /*
    @JoinColumns({
        @JoinColumn(name = "PERSONA_id", referencedColumnName = "id", nullable = false),
      // @JoinColumn(name = "PERSONA_LOCALIDAD_id", referencedColumnName = "LOCALIDAD_id", nullable = false)
    })

    

    @OneToOne(optional = false)
    private Persona persona;
    */
    
    /*
    public User(Long id, String username, String email, String password, String token, Persona persona) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.token = token;
        this.persona = persona;
    }
    */

    public User(Long id, String username, String email, String password, String token) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.token = token;
    }

  

   
    
    

   
    
    public User() {
    }

   

    
/*
    public User(int pERSONAidPersona, int pERSONALOCALIDADidLocalidad) {
        this.userPK = new UserPK(pERSONAidPersona, pERSONALOCALIDADidLocalidad);
    }
*/
 
    
    
}
