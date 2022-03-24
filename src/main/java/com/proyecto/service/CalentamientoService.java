
package com.proyecto.service;

import com.proyecto.domain.Calentamiento;
import java.util.List;

public interface CalentamientoService {
    public List<Calentamiento> getEjercicios();
    
    public void save(Calentamiento ejercicio);
    
    public void delete(Calentamiento ejercicio);
    
    public Calentamiento getEjercicio(Calentamiento ejercicio);
}
