/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.SpringBoot.Controller;

//deemos mapear para indicarle que es nuestra clase controlaadora con rest contrllier y el Import correspondiente

import com.ejemplo.SpringBoot.model.Acercade;
import com.ejemplo.SpringBoot.model.Educacion;
import com.ejemplo.SpringBoot.model.Experiencia;
import com.ejemplo.SpringBoot.model.Localidad;
import com.ejemplo.SpringBoot.model.Persona;
import com.ejemplo.SpringBoot.model.PersonaEducacion;
import com.ejemplo.SpringBoot.model.Provincia;
import com.ejemplo.SpringBoot.model.Proyecto;
import com.ejemplo.SpringBoot.model.Skill;
import com.ejemplo.SpringBoot.model.TipoEducacion;
import com.ejemplo.SpringBoot.model.User;
import com.ejemplo.SpringBoot.service.IAcercadeService;
import com.ejemplo.SpringBoot.service.IEducacionService;
import com.ejemplo.SpringBoot.service.IExperienciaService;
import com.ejemplo.SpringBoot.service.ILocalidadService;
import com.ejemplo.SpringBoot.service.IPersonaEducacionService;
import com.ejemplo.SpringBoot.service.IPersonaService;
import com.ejemplo.SpringBoot.service.IProvinciaService;
import com.ejemplo.SpringBoot.service.IProyectoService;
import com.ejemplo.SpringBoot.service.ISkillService;
import com.ejemplo.SpringBoot.service.ITipoEducacionService;
import com.ejemplo.SpringBoot.service.IUserService;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import java.util.Date;

import java.util.List;
//import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin("**")
@CrossOrigin(origins = "*")
//@CrossOrigin( origins = "https://frontendargprogprueba.web.app/")
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
    
     @GetMapping("/persona/{id}")
    public Persona buscarPersona(@PathVariable Long id){
    //return listaPersonas;
    return perServ.buscarPersona(id);
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
    
      @PutMapping("editar/persona/{id}")
    public void editarPersona(@PathVariable Long id,@RequestBody Persona p){
    
    perServ.editarPersona(id, p);
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
   
    
    
   
    @GetMapping("buscar/localidad/{id}")
    public Localidad buscarLocalidad(@PathVariable Long id){
    
    return locServ.buscarLocalidad(id);
    
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
    
    @PutMapping("editar/provincia/{id}")
    public void editarProvincia(@PathVariable Long id,@RequestBody Provincia p){
    
    provServ.editarProvincia(id, p);
    }
    
    
       @GetMapping("buscar/provincia/{id}")
    public void buscarProvincia(@PathVariable Long id){
    
    provServ.buscarProvincia(id);
    }
    
    
    
    //--------------------Fin Provincia------------------
   //--------------------Inicio Skill------------------
     @Autowired
    private ISkillService skiServ;      
    @PreAuthorize("hasRole('ADMIN')")   
    @PostMapping("/new/skill")
    public void agregarSkill(@RequestBody Skill prov){
        skiServ.crearSkill(prov);
    }
        
    @GetMapping("/ver/skills")
    @ResponseBody
    public List<Skill> verSkills(){
    return skiServ.verSkills();
    }
     @PreAuthorize("hasRole('ADMIN')")          
    @DeleteMapping("/eliminar/skill/{id}")
    public void borrarSkill(@PathVariable Long id){
        skiServ.borrarSkill(id);
    }
     @PreAuthorize("hasRole('ADMIN')")   
     @PutMapping("editar/skill/{id}")
    public void editarSkill(@PathVariable Long id,@RequestBody Skill p){
    
    skiServ.editarSkill(id, p);
    }
     @PreAuthorize("hasRole('ADMIN')")   
    @PutMapping("edit/skill/")
    public void editarSkill(@RequestBody Skill p){
    
  skiServ.editarSkill( p);
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
    @PutMapping("/editar/experiencia/{id}")
    public void editarExperiencia(@PathVariable Long id,@RequestBody Experiencia p){
    
    expServ.editarExperiencia(id, p);
    }
    
    //--------------------Fin Experiencia-----------------
    
      //--------------------Inicio Proyecto------------------
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
    
    @PutMapping("/editar/proyecto/{id}")
    public void editarProyecto(@PathVariable Long id,@RequestBody Proyecto p){
    
    proServ.editarProyecto(id, p);
    }
    
    
    //--------------------Fin Proyecto------------------
    
     //--------------------Inicio PersonaEducacion------------------
     @Autowired
    private IPersonaEducacionService pedServ;      
        
    @PostMapping("/new/personaeducacion")
    public void agregarPersonaEducacion(@RequestBody PersonaEducacion prov){
        pedServ.crearPersonaEducacion(prov);
    }
        
    @GetMapping("/ver/personaeducaciones")
    @ResponseBody
    public List<PersonaEducacion> verPersonaEducaciones(){
    return pedServ.verPersonaEducaciones();
    }
           
    @DeleteMapping("/eliminar/personaeducacion/{id}")
    public void borrarPersonaEducacion(@PathVariable Long id){
        pedServ.borrarPersonaEducacion(id);
    }
    
    
    
//--------------------Fin PersonaEducacion------------------
    
    //--------------------Inicio Acercade------------------
    
     @Autowired
    private IAcercadeService acdServ;      
        
    @PostMapping("/new/acercade")
    public void agregarAcercade(@RequestBody Acercade p){
       acdServ.crearAcercade(p);
    }
        
    @GetMapping("/ver/acercades")
    @ResponseBody
    public List<Acercade> verAcercades(){
    return acdServ.verAcercades();
    }
    
      @GetMapping("buscar/acercade")
      public Acercade buscarAcercade(@PathVariable Long id){
        return  acdServ.buscarAcercade(id);
        }
      
      
     
    @DeleteMapping("/eliminar/acercade/{id}")
    public void borrarAcercade (@PathVariable Long id){
        acdServ.borrarAcercade(id);
    } 
    
    
    
    
  @PutMapping("editar/acercade/{id}")
    public void editarEducacion(@PathVariable Long id,@RequestBody Acercade p){
    
    acdServ.editarAcercade(id, p);
    }
    //--------------------Fin Acercade------------------
    
    //--------------------Inicio TipoEducacion------------------
     @Autowired
    private ITipoEducacionService tedServ;      
        
    @PostMapping("/new/tipoeducacion")
    public void agregarTipoEducacion(@RequestBody TipoEducacion p){
        tedServ.crearTipoEducacion(p);
    }
        
    @GetMapping("/ver/tipoeducaciones")
    @ResponseBody
    public List<TipoEducacion> verTipoEducaciones(){
    return tedServ.verTipoEducaciones();
    }
           
    @DeleteMapping("/eliminar/tipoeducacion/{id}")
    public void borrarTipoEducacion(@PathVariable Long id){
        tedServ.borrarTipoEducacion(id);
    }
    
    
    //--------------------Fin TipoEducacion------------------
    
    
     //--------------------Inicio Educacion------------------
     @Autowired
    private IEducacionService eduServ;      
        
    @PostMapping("/new/educacion")
    public void agregarEducacion(@RequestBody Educacion p){
        eduServ.crearEducacion(p);
    }
        
 
     @GetMapping("/ver/educaciones")
    @ResponseBody
    public List<Educacion> verEducaciones(){
    return eduServ.verEducaciones();
    }
     @GetMapping("/buscar/educacion/{id}")
    @ResponseBody
    public Educacion buscarEducacion(@PathVariable Long id){
    return eduServ.buscarEducacion(id);
    }
           
    @DeleteMapping("/eliminar/educacion/{id}")
    public void borrarEducacion(@PathVariable Long id){
        eduServ.borrarEducacion(id);
    }
    @PutMapping("editar/educacion/{id}")
    public void editarEducacion(@PathVariable Long id,@RequestBody Educacion p){
    
    eduServ.editarEducacion(id, p);
    }
    @PutMapping("edit/educacion/")
    public void editarEducacion(@RequestBody Educacion p){
    
    eduServ.editarEducacion(p);
    }
    //--------------------Fin Educacion------------------
     //--------------------Inicio USER------------------
    
      @Autowired
    private IUserService userServ;      
        
    @PostMapping("/new/user")
    public void agregarUser(@RequestBody User p){
        userServ.crearUser(p);
    }
        
    @GetMapping("/ver/users")
    @ResponseBody
    public List<User> verUsers(){
    return userServ.verUsers();
    }
           
    @DeleteMapping("/eliminar/user/{id}")
    public void borrarUser(@PathVariable Long id){
        userServ.borrarUser(id);
    }
    
     //-------------------FIN USER------------------
    @PostMapping("/usuario")
     public User nuevoUsuario(@RequestBody User p) {
        User usuario= new User();
        
        usuario.setEmail(p.getEmail());
        usuario.setPassword(p.getPassword());
        usuario.setUsername(p.getUsername());
       // usuario.setToken(getJWTToken(p.getToken()));
        
        //usuarioController.save(usuario);
        //return usuario;
         
         return userServ.nuevoUsuario(usuario);
    }
      /*  
    private String getJWTToken(String username) {
        String secretKey = "frase";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
        String token = Jwts.builder()
                .setId("apiBackend")
                .setSubject(username)
                .claim("authorities", grantedAuthorities
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                // SI SE QUIERE HACER QUE EL TOKEN EXPIRE LUEGO DE UN TIEMPO USAMOS LO SIGUIENTE * 900000 = 15 MINUTOS - 1 MINUTO  = 60000 MILISEGUNDOS
		.setExpiration(new Date(System.currentTimeMillis()+900000))
                
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
                .compact();
        return "Bearer " + token;
        //agrego bearer para ya llegarlo de la base de datos, puedo no ponerlo pero se recomienda porque es facil de olvidar
    }*/

    
    
}
