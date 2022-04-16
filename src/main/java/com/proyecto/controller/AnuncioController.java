
package com.proyecto.controller;

import com.proyecto.domain.Anuncio;
import com.proyecto.domain.Usuario;
import com.proyecto.service.AnuncioService;
import com.proyecto.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class AnuncioController {
    @Autowired
    private AnuncioService anuncioService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/anuncio/listado")
    public String inicio(Model model){
        var anuncios = anuncioService.getAnuncios();
        model.addAttribute("anuncios", anuncios);
        return "/anuncio/listado";
    }
    
    @GetMapping("anuncio/nuevo")
    public String nuevaAnuncio(Anuncio anuncio){
        return "/anuncio/modificar";
    }
    
    @PostMapping("anuncio/guardar")
    public String guardarAnuncio(Anuncio anuncio){
        Usuario usuario = new Usuario();
        Long idUsuario = (long)1;
        usuario.setIdUsuario(idUsuario);
        usuario = usuarioService.getUsuario(usuario);
        anuncio.setUsuario(usuario);
        anuncioService.save(anuncio);
        return "redirect:/anuncio/listado";
    }
    
    @GetMapping("/anuncio/modificar/{idAnuncio}")
    public String modificarAnuncio(Anuncio anuncio, Model model){
        anuncio = anuncioService.getAnuncio(anuncio);
        model.addAttribute("anuncio", anuncio);
        return "/anuncio/modificar";
    }
    
    @GetMapping("/anuncio/eliminar/{idAnuncio}")
    public String eliminarAnuncio(Anuncio anuncio){
        anuncioService.delete(anuncio);
        return "redirect:/anuncio/listado";
    }
}
