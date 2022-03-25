
package com.proyecto.service;

import com.proyecto.domain.Calentamiento;
import java.util.List;
import org.springframework.stereotype.Service;

public interface CalentamientoService {
    public List<Calentamiento> getCalentamientos();
    
    public void save(Calentamiento calentamiento);
    
    public void delete(Calentamiento calentamiento);
    
    public Calentamiento getCalentamiento(Calentamiento calentamiento);
}
