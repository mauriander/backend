/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejemplo.SpringBoot.Security.Repository;

import com.ejemplo.SpringBoot.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MAURICIO
 */
@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario , Integer>{
      Optional<Usuario> findByNombreUsuario(String nombreUsuario);
      
      boolean existsByNombreUsuario(String nombreUsuario);
      boolean existsByEmail(String email);
    
}
