
package com.proyecto.service;

import com.proyecto.domain.Empresa;
import java.util.List;

public interface EmpresaService {
    public List<Empresa> getEmpresas();
    
    public void save(Empresa empresa);
    
    public void delete(Empresa empresa);
    
    public Empresa getEmpresa(Empresa empresa);
}
