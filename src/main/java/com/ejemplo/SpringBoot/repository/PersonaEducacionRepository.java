
package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.PersonaEducacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaEducacionRepository extends JpaRepository<PersonaEducacion, Long>{
    
}

