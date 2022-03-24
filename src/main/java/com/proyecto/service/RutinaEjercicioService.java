
package com.proyecto.service;

import com.proyecto.domain.RutinaEjercicio;
import java.util.List;

public interface RutinaEjercicioService  {
    public List<RutinaEjercicio> getRutinasEjercicios();
    
    public void save(RutinaEjercicio rutinaEjercicio);
    
    public void delete(RutinaEjercicio rutinaEjercicio);
    
    public RutinaEjercicio getRutinaEjercicio(RutinaEjercicio rutinaEjercicio);
}
