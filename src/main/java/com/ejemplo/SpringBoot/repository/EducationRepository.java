/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author MAURICIO
 */
@Repository
public interface EducationRepository extends JpaRepository<Education , Long>{
    
}

