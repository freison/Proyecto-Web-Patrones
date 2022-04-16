
package com.proyecto.controller;

import com.proyecto.domain.Calentamiento;
import com.proyecto.service.CalentamientoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class CalentamientoController {
    @Autowired
    private CalentamientoService calentamientoService;
    
    @GetMapping("/calentamiento/listado")
    public String inicio(Model model){
        var calentamientos = calentamientoService.getCalentamientos();
        model.addAttribute("calentamientos", calentamientos);
        return "/calentamiento/listado";
    }
    
    @GetMapping("calentamiento/nuevo")
    public String nuevaCalentamiento(Calentamiento calentamiento){
        return "/calentamiento/modificar";
    }
    
    @PostMapping("calentamiento/guardar")
    public String guardarCalentamiento(Calentamiento calentamiento){
        calentamientoService.save(calentamiento);
        return "redirect:/calentamiento/listado";
    }
    
    @GetMapping("/calentamiento/modificar/{idCalentamiento}")
    public String modificarCalentamiento(Calentamiento calentamiento, Model model){
        calentamiento = calentamientoService.getCalentamiento(calentamiento);
        model.addAttribute("calentamiento", calentamiento);
        return "/calentamiento/modificar";
    }
    
    @GetMapping("/calentamiento/eliminar/{idCalentamiento}")
    public String eliminarCalentamiento(Calentamiento calentamiento){
        calentamientoService.delete(calentamiento);
        return "redirect:/calentamiento/listado";
    }
}
