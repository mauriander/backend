/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.TipoEducacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RIO SALADO SRL
 */
@Repository
public interface TipoEducacionRepository extends JpaRepository<TipoEducacion, Long >{
    
}
