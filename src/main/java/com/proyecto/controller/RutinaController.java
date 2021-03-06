
package com.proyecto.controller;

import com.proyecto.domain.Rutina;
import com.proyecto.domain.Usuario;
import com.proyecto.service.RutinaService;
import com.proyecto.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class RutinaController {
    @Autowired
    private RutinaService rutinaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/rutina/listado")
    public String inicio(Model model){
        var rutinas = rutinaService.getRutinas();
        model.addAttribute("rutinas", rutinas);
        return "/rutina/listado";
    }
    
    @GetMapping("/rutina/nuevo")
    public String nuevaRutina(Rutina rutina, Model model){
        model.addAttribute("rutina", rutina);
        return "/rutina/modificar";
    }
    
    @PostMapping("rutina/guardar")
    public String guardarRutina(Rutina rutina){
        Usuario usuario = new Usuario();
        Long idUsuario = (long)1;
        usuario.setIdUsuario(idUsuario);
        usuario = usuarioService.getUsuario(usuario);
        rutina.setUsuario(usuario);
        rutinaService.save(rutina);
        return "redirect:/rutina/listado";
    }
    
    @GetMapping("/rutina/modificar/{idRutina}")
    public String modificarRutina(Rutina rutina, Model model){
        rutina = rutinaService.getRutina(rutina);
        model.addAttribute("rutina", rutina);
        return "/rutina/modificar";
    }
    
    @GetMapping("/rutina/eliminar/{idRutina}")
    public String eliminarRutina(Rutina rutina){
        rutinaService.delete(rutina);
        return "redirect:/rutina/listado";
    }
}
