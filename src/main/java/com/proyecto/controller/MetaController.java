
package com.proyecto.controller;

import com.proyecto.domain.Meta;
import com.proyecto.domain.Usuario;
import com.proyecto.service.MetaService;
import com.proyecto.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MetaController {
    @Autowired
    private MetaService metaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/meta/listado")
    public String inicio(Model model){
        var metas = metaService.getMetas();
        model.addAttribute("metas", metas);
        return "/meta/listado";
    }
    
    @GetMapping("meta/nuevo")
    public String nuevaMeta(Meta meta){
        return "/meta/modificar";
    }
    
    @PostMapping("meta/guardar")
    public String guardarMeta(Meta meta){
        Usuario usuario = new Usuario();
        Long idUsuario = (long)1;
        usuario.setIdUsuario(idUsuario);
        usuario = usuarioService.getUsuario(usuario);
        meta.setUsuario(usuario);
        metaService.save(meta);
        return "redirect:/meta/listado";
    }
    
    @GetMapping("/meta/modificar/{idMeta}")
    public String modificarMeta(Meta meta, Model model){
        meta = metaService.getMeta(meta);
        model.addAttribute("meta", meta);
        return "/meta/modificar";
    }
    
    @GetMapping("/meta/eliminar/{idMeta}")
    public String eliminarMeta(Meta meta){
        metaService.delete(meta);
        return "redirect:/meta/listado";
    }
}
