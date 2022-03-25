
package com.proyecto.service;

import com.proyecto.domain.Rol;
import java.util.List;

public interface RolService {
    public List<Rol> getRoles();
    
    public void save(Rol rol);
    
    public void delete(Rol rol);
    
    public Rol getRol(Rol rol);
}
