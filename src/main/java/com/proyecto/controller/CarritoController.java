
package com.proyecto.controller;

import com.proyecto.domain.Articulo;
import com.proyecto.domain.Factura;
import com.proyecto.service.ArticuloService;
import com.proyecto.service.CarritoService;
import java.util.Hashtable;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class CarritoController {
    
    @Autowired
    CarritoService carritoService;
    
    @Autowired
    ArticuloService articuloService;
    
    // Testing T2
    @GetMapping("/carrito/agregar/{idArticulo}")
    public String agregarACarrito(Articulo articulo){
        articulo = articuloService.getArticulo(articulo);
        carritoService.save(articulo);
        
        return "redirect:/tienda";
    }
    
    @GetMapping("/carrito/listado")
    public String carritoListado(Model model){
        Hashtable<Articulo, Long> articulos = carritoService.getArticulos();
        double carritoTotal = 0.0;
        int totalCantidad = 0;
        
        for(var a : articulos.entrySet()){
            carritoTotal += (a.getValue() * a.getKey().getPrecio());
            totalCantidad += a.getValue();
        }
        
        model.addAttribute("carritoTotal", carritoTotal);
        model.addAttribute("totalArticulos", articulos.size());
        model.addAttribute("articulos", articulos);
        model.addAttribute("totalCantidad", totalCantidad);
        model.addAttribute("factura", new Factura());
        
        return "/carrito/listado";
    }
    
    @GetMapping("/carrito/guardar/{idArticulo}")
    public String guardarArticulo(Articulo articulo){
        carritoService.save(articulo);
        
        System.out.println(articulo);
        System.out.println(carritoService.getArticulos());
        
        return "redirect:/";
    }
    
    @GetMapping("/carrito/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo){
        System.out.println("/carrito/eliminar");
        carritoService.delete(articulo);
        return "redirect:/carrito/listado";
    }
}
