
package com.proyecto.controller;

import com.proyecto.domain.Rol;
import com.proyecto.service.RolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class RolController {
    @Autowired
    private RolService rolService;
    
    @GetMapping("/rol/listado")
    public String inicio(Model model){
        var roles = rolService.getRoles();
        model.addAttribute("roles", roles);
        
        return "/rol/listado";
    }
    
    @GetMapping("rol/nuevo")
    public String nuevaRol(Rol rol){
        return "/rol/modificar";
    }
    
    @PostMapping("rol/guardar")
    public String guardarRol(Rol rol){
        rolService.save(rol);
        return "redirect:/rol/listado";
    }
    
    @GetMapping("/rol/modificar/{idRol}")
    public String modificarRol(Rol rol, Model model){
        rol = rolService.getRol(rol);
        model.addAttribute("rol", rol);
        return "/rol/modificar";
    }
    
    @GetMapping("/rol/eliminar/{idRol}")
    public String eliminarRol(Rol rol){
        rolService.delete(rol);
        return "redirect:/rol/listado";
    }
}
