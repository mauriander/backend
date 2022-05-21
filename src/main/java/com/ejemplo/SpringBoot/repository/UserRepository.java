
package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.Experiencia;
import com.ejemplo.SpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author MAURICIO
 */
@Repository
public interface UserRepository extends JpaRepository<User , Long>{
    
}