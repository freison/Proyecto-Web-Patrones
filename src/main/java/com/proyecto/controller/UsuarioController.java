
package com.proyecto.controller;

import com.proyecto.dao.EmpresaDao;
import com.proyecto.dao.RolDao;
import com.proyecto.domain.Usuario;
import com.proyecto.service.EmpresaService;
import com.proyecto.service.RolService;
import com.proyecto.service.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private EmpresaService empresaService;
    
    @Autowired
    private RolService rolService;
    
    @GetMapping("/usuario/listado")
    public String inicio(Model model){
        var usuarios = usuarioService.getUsuarios();
        System.out.println(usuarios);
        model.addAttribute("usuarios", usuarios);
        
        return "/usuario/listado";
    }
    
    @GetMapping("usuario/nuevo")
    public String nuevaUsuario(Usuario usuario, Model model){
        var empresas = empresaService.getEmpresas();
        var roles = rolService.getRoles();
        model.addAttribute("empresas", empresas);
        model.addAttribute("roles", roles);
        
        return "/usuario/modificar";
    }
    
    @PostMapping("/usuario/guardar")
    public String guardarUsuario(Usuario usuario){
        usuarioService.save(usuario);
        return "redirect:/usuario/listado";
    }
    
    @GetMapping("/usuario/modificar/{idUsuario}")
    public String modificarUsuario(Usuario usuario, Model model){
        usuario = usuarioService.getUsuario(usuario);
        var empresas = empresaService.getEmpresas();
        var roles = rolService.getRoles();
        model.addAttribute("usuario", usuario);
        model.addAttribute("empresas", empresas);
        model.addAttribute("roles", roles);
        
        return "/usuario/modificar";
    }
    
    @GetMapping("/usuario/eliminar/{idUsuario}")
    public String eliminarUsuario(Usuario usuario){
        usuarioService.delete(usuario);
        return "redirect:/usuario/listado";
    }
}
