
package com.proyecto.controller;

import com.proyecto.domain.Alerta;
import com.proyecto.domain.Usuario;
import com.proyecto.service.AlertaService;
import com.proyecto.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class AlertaController {
    @Autowired
    private AlertaService alertaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/alerta/listado")
    public String inicio(Model model){
        var alertas = alertaService.getAlertas();
        model.addAttribute("alertas", alertas);
        return "/alerta/listado";
    }
    
    @GetMapping("alerta/nuevo")
    public String nuevaAlerta(Alerta alerta){
        return "/alerta/modificar";
    }
    
    @PostMapping("alerta/guardar")
    public String guardarAlerta(Alerta alerta){
        Usuario usuario = new Usuario();
        Long idUsuario = (long)1;
        usuario.setIdUsuario(idUsuario);
        usuario = usuarioService.getUsuario(usuario);
        alerta.setUsuario(usuario);
        alertaService.save(alerta);
        return "redirect:/alerta/listado";
    }
    
    @GetMapping("/alerta/modificar/{idAlerta}")
    public String modificarAlerta(Alerta alerta, Model model){
        alerta = alertaService.getAlerta(alerta);
        model.addAttribute("alerta", alerta);
        return "/alerta/modificar";
    }
    
    @GetMapping("/alerta/eliminar/{idAlerta}")
    public String eliminarAlerta(Alerta alerta){
        alertaService.delete(alerta);
        return "redirect:/alerta/listado";
    }
}
