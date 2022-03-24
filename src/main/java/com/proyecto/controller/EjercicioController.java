
package com.proyecto.controller;

import com.proyecto.domain.Ejercicio;
import com.proyecto.service.EjercicioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class EjercicioController {
    @Autowired
    private EjercicioService ejercicioService;
    
    @GetMapping("/ejercicio/listado")
    public String inicio(Model model){
        var ejercicios = ejercicioService.getEjercicios();
        
        return "/ejercicio/listado";
    }
    
    @GetMapping("ejercicio/nuevo")
    public String nuevaEjercicio(Ejercicio ejercicio){
        return "/ejercicio/modificar";
    }
    
    @PostMapping("ejercicio/guardar")
    public String guardarEjercicio(Ejercicio ejercicio){
        ejercicioService.save(ejercicio);
        return "redirect:/ejercicio/listado";
    }
    
    @GetMapping("/ejercicio/modificar/{idEjercicio}")
    public String modificarEjercicio(Ejercicio ejercicio, Model model){
        ejercicio = ejercicioService.getEjercicio(ejercicio);
        model.addAttribute("ejercicio", ejercicio);
        return "/ejercicio/modifcar";
    }
    
    @GetMapping("/ejercicio/eliminar/{idEjercicio}")
    public String eliminarEjercicio(Ejercicio ejercicio){
        ejercicioService.delete(ejercicio);
        return "redirect:/ejercicio/listado";
    }
}
