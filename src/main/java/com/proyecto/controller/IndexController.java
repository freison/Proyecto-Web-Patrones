package com.proyecto.controller;


import com.proyecto.domain.Articulo;
import com.proyecto.service.ArticuloService;
import com.proyecto.service.CarritoService;
import com.proyecto.service.UsuarioService;
import java.util.Hashtable;
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
    
    @Autowired
    private CarritoService carritoService;
    
    @Autowired
    private ArticuloService articuloService;
    
    @GetMapping("/")
    public String inicio(Model model){
        var usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios",usuarios);
        return "/index";
    }
    
    @GetMapping("/tienda")
    public String tienda(Model model){
        
        Hashtable<Articulo, Long> listaArticulos = carritoService.getArticulos();
        int cantidadProductos = 0;
        
        for(var a : listaArticulos.entrySet()){
            cantidadProductos += a.getValue();
        }
        
        var articulos = articuloService.getArticulos();
        model.addAttribute("articulos", articulos);
        model.addAttribute("cantidadProductos", cantidadProductos);
        
        return "tienda";
    }
}
