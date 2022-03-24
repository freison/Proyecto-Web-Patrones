
package com.proyecto.service;

import com.proyecto.domain.RutinaCalentamiento;
import java.util.List;

public interface RutinaCalentamientoService  {
    public List<RutinaCalentamiento> getRutinasCalentamientos();
    
    public void save(RutinaCalentamiento rutinaCalentamiento);
    
    public void delete(RutinaCalentamiento rutinaCalentamiento);
    
    public RutinaCalentamiento getRutinaCalentamiento(RutinaCalentamiento rutinaCalentamiento);
}
