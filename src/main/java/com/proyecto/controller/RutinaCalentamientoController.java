
package com.proyecto.controller;

import com.proyecto.domain.RutinaCalentamiento;
import com.proyecto.service.RutinaCalentamientoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class RutinaCalentamientoController {
    @Autowired
    private RutinaCalentamientoService rutinaCalentamientoService;
    
    @GetMapping("/rutina-calentamiento/listado")
    public String inicio(Model model){
        var rutinaCalentamientos = rutinaCalentamientoService.getRutinasCalentamientos();
        model.addAttribute("rutinaCalentamientos", rutinaCalentamientos);
        
        return "/rutina-calentamiento/listado";
    }
    
    @GetMapping("rutina-calentamiento/nuevo")
    public String nuevaRutinaCalentamiento(RutinaCalentamiento rutinaCalentamiento){
        return "/rutina-calentamiento/modificar";
    }
    
    @PostMapping("rutina-calentamiento/guardar")
    public String guardarRutinaCalentamiento(RutinaCalentamiento rutinaCalentamiento){
        rutinaCalentamientoService.save(rutinaCalentamiento);
        return "redirect:/rutina-calentamiento/listado";
    }
    
    @GetMapping("/rutina-calentamiento/modificar/{idRutinaCalentamiento}")
    public String modificarRutinaCalentamiento(RutinaCalentamiento rutinaCalentamiento, Model model){
        rutinaCalentamiento = rutinaCalentamientoService.getRutinaCalentamiento(rutinaCalentamiento);
        model.addAttribute("rutinaCalentamiento", rutinaCalentamiento);
        return "/rutina-calentamiento/modifcar";
    }
    
    @GetMapping("/rutina-calentamiento/eliminar/{idRutinaCalentamiento}")
    public String eliminarRutinaCalentamiento(RutinaCalentamiento rutinaCalentamiento){
        rutinaCalentamientoService.delete(rutinaCalentamiento);
        return "redirect:/rutina-calentamiento/listado";
    }
}
