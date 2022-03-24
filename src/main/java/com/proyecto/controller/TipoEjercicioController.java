
package com.proyecto.controller;

import com.proyecto.domain.TipoEjercicio;
import com.proyecto.service.TipoEjercicioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class TipoEjercicioController {
    @Autowired
    private TipoEjercicioService tipoEjercicioService;
    
    @GetMapping("/ejercicio/listado")
    public String inicio(Model model){
       var ejercicios = tipoEjercicioService.getTiposEjercicio();
       
       model.addAttribute("ejercicios", ejercicios);
       return "/ejercicio/listado";
    }
    
    @GetMapping("ejercicio/nuevo")
    public String nuevoEjercicio(TipoEjercicio ejercicio){
        return "/ejercicio/modificar";
    }
    
    @PostMapping("/ejercicio/guardar")
    public String guardarEjercicio(TipoEjercicio ejercicio){
        tipoEjercicioService.save(ejercicio);
        return "redirect:/ejercicio/listado";
    }
    
    @GetMapping("/ejercicio/modificar/{idEjercicio}")
    public String modificarEjercicio(TipoEjercicio ejercicio, Model model){
        ejercicio = tipoEjercicioService.getTipoEjercicio(ejercicio);
        model.addAttribute("ejercicio", ejercicio);
        return "/ejercicio/modificar";
    }
    
    @GetMapping("/ejercicio/eliminar/{idEjercicio}")
    public String eliminarEjercicio(TipoEjercicio ejercicio){
        tipoEjercicioService.delete(ejercicio);
        return "redirect:/ejercicio/listado";
    }
}
