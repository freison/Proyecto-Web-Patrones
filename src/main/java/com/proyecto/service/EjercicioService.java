
package com.proyecto.service;

import com.proyecto.domain.Ejercicio;
import java.util.List;

public interface EjercicioService {
    public List<Ejercicio> getEjercicios();
    
    public void save(Ejercicio ejercicio);
    
    public void delete(Ejercicio ejercicio);
    
    public Ejercicio getEjercicio(Ejercicio ejercicio);
}
