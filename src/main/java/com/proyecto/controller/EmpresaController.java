
package com.proyecto.controller;

import com.proyecto.domain.Empresa;
import com.proyecto.service.EmpresaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class EmpresaController {
    
    @Autowired
    private EmpresaService empresaService;
    
    @GetMapping("/empresa/listado")
    public String inicio(Model model){
        var empresas = empresaService.getEmpresas();
        model.addAttribute("empresas", empresas);
        
        return "/empresa/listado";
    }
    
    @GetMapping("empresa/nuevo")
    public String nuevaEmpresa(Empresa empresa){
        return "/empresa/modificar";
    }
    
    @PostMapping("empresa/guardar")
    public String guardarEmpresa(Empresa empresa){
        empresaService.save(empresa);
        return "redirect:/empresa/listado";
    }
    
    @GetMapping("/empresa/modificar/{idEmpresa}")
    public String modificarEmpresa(Empresa empresa, Model model){
        
        empresa = empresaService.getEmpresa(empresa);
        model.addAttribute("empresa", empresa);
        
        return "/empresa/modificar";
    }
    
    @GetMapping("/empresa/eliminar/{idEmpresa}")
    public String eliminarEmpresa(Empresa empresa){
        empresaService.delete(empresa);
        return "redirect:/empresa/listado";
    }
}
