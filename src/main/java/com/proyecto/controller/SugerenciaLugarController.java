
package com.proyecto.controller;

import com.proyecto.domain.SugerenciaLugar;
import com.proyecto.service.SugerenciaLugarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class SugerenciaLugarController {
    @Autowired
    private SugerenciaLugarService sugerenciaService;
    
    @GetMapping("/sugerencia/listado")
    public String inicio(Model model){
        var sugerencias = sugerenciaService.getSugerenciaLugares();
        model.addAttribute("sugerencias", sugerencias);
        
        return "/sugerencia/listado";
    }
    
    @GetMapping("sugerencia/nuevo")
    public String nuevaSugerenciaLugar(SugerenciaLugar sugerencia){
        return "/sugerencia/modificar";
    }
    
    @PostMapping("sugerencia/guardar")
    public String guardarSugerenciaLugar(SugerenciaLugar sugerencia){
        sugerenciaService.save(sugerencia);
        return "redirect:/sugerencia/listado";
    }
    
    @GetMapping("/sugerencia/modificar/{idSugerenciaLugar}")
    public String modificarSugerenciaLugar(SugerenciaLugar sugerencia, Model model){
        sugerencia = sugerenciaService.getSugerenciaLugar(sugerencia);
        model.addAttribute("sugerencia", sugerencia);
        return "/sugerencia/modifcar";
    }
    
    @GetMapping("/sugerencia/eliminar/{idSugerenciaLugar}")
    public String eliminarSugerenciaLugar(SugerenciaLugar sugerencia){
        sugerenciaService.delete(sugerencia);
        return "redirect:/sugerencia/listado";
    }
}
