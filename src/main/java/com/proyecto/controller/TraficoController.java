
package com.proyecto.controller;

import com.proyecto.domain.Trafico;
import com.proyecto.domain.Usuario;
import com.proyecto.service.TraficoService;
import com.proyecto.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class TraficoController {
    @Autowired
    private TraficoService traficoService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/trafico/listado")
    public String inicio(Model model){
        var traficos = traficoService.getTraficos();
        model.addAttribute("traficos", traficos);
        return "/trafico/listado";
    }
    
    @GetMapping("trafico/nuevo")
    public String nuevaTrafico(Trafico trafico){
        return "/trafico/modificar";
    }
    
    @PostMapping("trafico/guardar")
    public String guardarTrafico(Trafico trafico){
        Usuario usuario = new Usuario();
        Long idUsuario = (long)1;
        usuario.setIdUsuario(idUsuario);
        usuario = usuarioService.getUsuario(usuario);
        trafico.setUsuario(usuario);
        traficoService.save(trafico);
        return "redirect:/trafico/listado";
    }
    
    @GetMapping("/trafico/modificar/{idTrafico}")
    public String modificarTrafico(Trafico trafico, Model model){
        trafico = traficoService.getTrafico(trafico);
        model.addAttribute("trafico", trafico);
        return "/trafico/modificar";
    }
    
    @GetMapping("/trafico/eliminar/{idTrafico}")
    public String eliminarTrafico(Trafico trafico){
        traficoService.delete(trafico);
        return "redirect:/trafico/listado";
    }
}
