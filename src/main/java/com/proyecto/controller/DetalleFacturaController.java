
package com.proyecto.controller;

import com.proyecto.domain.DetalleFactura;
import com.proyecto.service.DetalleFacturaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class DetalleFacturaController {
    @Autowired
    private DetalleFacturaService detallefacturaService;
    
    
    @GetMapping("/detallefactura/listado")
    public String inicio(Model model){
        var detallefacturas = detallefacturaService.getDetalleFacturas();
        model.addAttribute("detallefacturas", detallefacturas);
        return "/detallefactura/listado";
    }
    
    @GetMapping("detallefactura/nuevo")
    public String nuevaDetalleFactura(DetalleFactura detallefactura){
        return "/detallefactura/modificar";
    }
    
    @PostMapping("detallefactura/guardar")
    public String guardarDetalleFactura(DetalleFactura detallefactura){
        detallefacturaService.save(detallefactura);
        return "redirect:/detallefactura/listado";
    }
    
    @GetMapping("/detallefactura/modificar/{idDetalleFactura}")
    public String modificarDetalleFactura(DetalleFactura detallefactura, Model model){
        detallefactura = detallefacturaService.getDetalleFactura(detallefactura);
        model.addAttribute("detallefactura", detallefactura);
        return "/detallefactura/modificar";
    }
    
    @GetMapping("/detallefactura/eliminar/{idDetalleFactura}")
    public String eliminarDetalleFactura(DetalleFactura detallefactura){
        detallefacturaService.delete(detallefactura);
        return "redirect:/detallefactura/listado";
    }
}
