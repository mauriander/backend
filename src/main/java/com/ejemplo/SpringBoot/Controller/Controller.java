/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.Controller;

//deemos mapear para indicarle que es nuestra clase controlaadora con rest contrllier y el Import correspondiente

import com.ejemplo.SpringBoot.model.Experiencia;
import com.ejemplo.SpringBoot.model.Localidad;
import com.ejemplo.SpringBoot.model.Persona;
import com.ejemplo.SpringBoot.model.Provincia;
import com.ejemplo.SpringBoot.model.Proyecto;
import com.ejemplo.SpringBoot.model.Skill;
import com.ejemplo.SpringBoot.service.IExperienciaService;
import com.ejemplo.SpringBoot.service.ILocalidadService;
import com.ejemplo.SpringBoot.service.IPersonaService;
import com.ejemplo.SpringBoot.service.IProvinciaService;
import com.ejemplo.SpringBoot.service.IProyectoService;
import com.ejemplo.SpringBoot.service.ISkillService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    //creo lista para simular base de datos
   /* 
    
    List<Persona> listaPersonas=new ArrayList();
    List<Localidad> listaLocalidades=new ArrayList();
        
    
    
    //local host /hola muestra Hola pigush
    @GetMapping("/hola/{nombre}")
    public String decirHola(@PathVariable String nombre,@PathVariable int edad){
    return "HOla pigush "+ nombre;
    }
    
     
    */
    //requestParam , sirve para utilizar sin especificar el nombre
     @GetMapping("/chau")
    public String decirChau(@RequestParam String nombre, @RequestParam int edad){
    return "Chau Pigush "+ nombre + "  Felices "+edad+" años";
    }
    
    @GetMapping("/hola")
    public String decirHola(){
    return "HOla pigush ";
    }
   
    //-------------------Inicio PERSONA Y LOCALIDAD------------------
  
    @Autowired
    private IPersonaService perServ;
    
    @Autowired
    private ILocalidadService locServ;
    
    //request body generalmente llega de un json
    @PostMapping("/new/persona")
    public void AgregarPersona(@RequestBody Persona pers){
    //listaPersonas.add(pers); esto era antes solo para prueba
    perServ.crearPersona(pers);
    
    }
    @PostMapping("/new/localidad")
    public void AgregarLocalidad(@RequestBody Localidad l){
    //listaLocalidades.add(l);
    locServ.crearLocalidad(l);
    }
    
    
    
    //response body para responder.... es decir para mostrar
    @GetMapping("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas(){
    //return listaPersonas;
    return perServ.verPersonas();
    }
    
    
    @GetMapping("/ver/localidades")
    @ResponseBody
    public List<Localidad> verLocalidades(){
    //return listaLocalidades;
    return locServ.verLocalidades();
    }
    
     @DeleteMapping("/eliminar/persona/{id}")
   public void EliminarPersona(@PathVariable Long id){
      
    //listaPersonas.remove(id);
    perServ.borrarPersona(id);
    }
    @DeleteMapping("/eliminar/localidad/{id}")
   public void EliminarLocalidad(@PathVariable Long id){
      // listaLocalidades.removeIf(Localidad -> Localidad.getId().equals(id));
    locServ.borrarLocalidad(id);
    }
    //-------------------FIN PERSONA Y LOCALIDAD------------------
   
   
    //-------------------Inicio Provincia------------------
    @Autowired
    private IProvinciaService provServ;      
        
    @PostMapping("/new/provincia")
    public void agregarProvincia(@RequestBody Provincia prov){
        provServ.crearProvincia(prov);
    }
        
    @GetMapping("/ver/provincias")
    @ResponseBody
    public List<Provincia> verProvincias(){
    return provServ.verProvincias();
    }
           
    @DeleteMapping("/eliminar/provincia/{id}")
    public void borrarProvincia(@PathVariable Long id){
        provServ.borrarProvincia(id);
    }
    
    
    //--------------------Fin Provincia------------------
   //--------------------Inicio Skill------------------
     @Autowired
    private ISkillService skiServ;      
        
    @PostMapping("/new/skill")
    public void agregarSkill(@RequestBody Skill prov){
        skiServ.crearSkill(prov);
    }
        
    @GetMapping("/ver/skills")
    @ResponseBody
    public List<Skill> verSkills(){
    return skiServ.verSkills();
    }
           
    @DeleteMapping("/eliminar/skill/{id}")
    public void borrarSkill(@PathVariable Long id){
        skiServ.borrarSkill(id);
    }
    
    
    //--------------------Fin Skill------------------
    
      //--------------------Inicio Experiencia-----------------
       @Autowired
    private IExperienciaService expServ;      
        
    @PostMapping("/new/experiencia")
    public void agregarExperiencia(@RequestBody Experiencia prov){
       expServ.crearExperiencia(prov);
    }
        
    @GetMapping("/ver/experiencias")
    @ResponseBody
    public List<Experiencia> verExperiencias(){
    return expServ.verExperiencias();
    }
           
    @DeleteMapping("/eliminar/experiencia/{id}")
    public void borrarExperiencia(@PathVariable Long id){
        expServ.borrarExperiencia(id);
    }
    
    
    //--------------------Fin Experiencia-----------------
    
      //--------------------Inicio Skill------------------
     @Autowired
    private IProyectoService proServ;      
        
    @PostMapping("/new/proyecto")
    public void agregarProyecto(@RequestBody Proyecto prov){
        proServ.crearProyecto(prov);
    }
        
    @GetMapping("/ver/proyectos")
    @ResponseBody
    public List<Proyecto> verProyectos(){
    return proServ.verProyectos();
    }
           
    @DeleteMapping("/eliminar/proyecto/{id}")
    public void borrarProyecto(@PathVariable Long id){
        proServ.borrarProyecto(id);
    }
    
    
    //--------------------Fin Skill------------------
}
