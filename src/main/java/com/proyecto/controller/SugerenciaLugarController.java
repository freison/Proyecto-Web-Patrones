
package com.proyecto.controller;

import com.proyecto.domain.SugerenciaLugar;
import com.proyecto.domain.Usuario;
import com.proyecto.service.SugerenciaLugarService;
import com.proyecto.service.UsuarioService;
import java.time.LocalDate;
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
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/sugerencia/listado")
    public String inicio(Model model){
        var sugerencias = sugerenciaService.getSugerenciaLugares();
        model.addAttribute("sugerencias", sugerencias);
        
        return "/sugerencia/listado";
    }
    
    @GetMapping("/sugerencia/nuevo")
    public String nuevaSugerenciaLugar(SugerenciaLugar sugerencia, Model model){
        model.addAttribute("sugerencia", sugerencia);
        return "/sugerencia/modificar";
    }
    
    @PostMapping("sugerencia/guardar")
    public String guardarSugerenciaLugar(SugerenciaLugar sugerencia){
        Usuario usuario = new Usuario();
        Long idUsuario = (long)1;
        usuario.setIdUsuario(idUsuario);
        usuario = usuarioService.getUsuario(usuario);
        sugerencia.setUsuario(usuario);
        sugerenciaService.save(sugerencia);
        return "redirect:/sugerencia/listado";
    }
    
    @GetMapping("/sugerencia/modificar/{idSugerencia}")
    public String modificarSugerenciaLugar(SugerenciaLugar sugerencia, Model model){
        sugerencia = sugerenciaService.getSugerenciaLugar(sugerencia);
        model.addAttribute("sugerencia", sugerencia);
        return "/sugerencia/modificar";
    }
    
    @GetMapping("/sugerencia/eliminar/{idSugerencia}")
    public String eliminarSugerenciaLugar(SugerenciaLugar sugerencia){
        sugerenciaService.delete(sugerencia);
        return "redirect:/sugerencia/listado";
    }
}
