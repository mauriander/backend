/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.Security.Controller;

import com.ejemplo.SpringBoot.Security.Dto.JwtDto;
import com.ejemplo.SpringBoot.Security.Dto.LoginUsuario;
import com.ejemplo.SpringBoot.Security.Dto.NuevoUsuario;
import com.ejemplo.SpringBoot.Security.Entity.Rol;
import com.ejemplo.SpringBoot.Security.Entity.Usuario;
import com.ejemplo.SpringBoot.Security.Enums.RolNombre;
import com.ejemplo.SpringBoot.Security.Service.RolService;
import com.ejemplo.SpringBoot.Security.Service.UsuarioService;
import com.ejemplo.SpringBoot.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MAURICIO
 */

//@RequestMapping("/auth")

@RestController
@CrossOrigin(origins = {"http://localhost:4200","https://frontendargprogprueba.web.app"})
//@CrossOrigin("**")
//@CrossOrigin(origins = "/**")
//@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    RolService rolService;
    
    @Autowired                       
    JwtProvider jwtProvider;
    
    //Creamos un usuario nuevo
    @PostMapping("/auth/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
    if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);
    
    if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())){
        return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
    
     if(usuarioService.existsByEmail(nuevoUsuario.getEmail())){
        return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        }
    Usuario usuario= new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
        nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
        
    Set<Rol> roles = new HashSet<>();
    roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
    
    
    if(nuevoUsuario.getRoles().contains("admin"))
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
    
    usuario.setRoles(roles);
    usuarioService.save(usuario);
    
    return new ResponseEntity(new Mensaje("Usuario guardado"),HttpStatus.CREATED);
    
    }
    
    @PostMapping("/auth/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
    if(bindingResult.hasErrors())
        return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
    Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken (
            loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
            
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt,userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto,HttpStatus.OK);
    }
      
}
