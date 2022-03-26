package com.proyecto.controller;


import com.proyecto.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
public class IndexController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/")
    public String inicio(Model model){
        var usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios",usuarios);
        return "/index";
    }
}