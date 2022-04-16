
package com.proyecto.controller;

import com.proyecto.domain.Factura;
import com.proyecto.domain.Usuario;
import com.proyecto.service.FacturaService;
import com.proyecto.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class FacturaController {
    @Autowired
    private FacturaService facturaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/factura/listado")
    public String inicio(Model model){
        var facturas = facturaService.getFacturas();
        model.addAttribute("facturas", facturas);
        return "/factura/listado";
    }
    
    @GetMapping("factura/nuevo")
    public String nuevaFactura(Factura factura){
        return "/factura/modificar";
    }
    
    @PostMapping("factura/guardar")
    public String guardarFactura(Factura factura){
        Usuario usuario = new Usuario();
        Long idUsuario = (long)1;
        usuario.setIdUsuario(idUsuario);
        usuario = usuarioService.getUsuario(usuario);
        factura.setUsuario(usuario);
        facturaService.save(factura);
        return "redirect:/factura/listado";
    }
    
    @GetMapping("/factura/modificar/{idFactura}")
    public String modificarFactura(Factura factura, Model model){
        factura = facturaService.getFactura(factura);
        model.addAttribute("factura", factura);
        return "/factura/modificar";
    }
    
    @GetMapping("/factura/eliminar/{idFactura}")
    public String eliminarFactura(Factura factura){
        facturaService.delete(factura);
        return "redirect:/factura/listado";
    }
}
