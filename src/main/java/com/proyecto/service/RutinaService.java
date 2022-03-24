
package com.proyecto.service;

import com.proyecto.domain.Rutina;
import java.util.List;

public interface RutinaService {
    public List<Rutina> getRutinas();
    
    public void save(Rutina rutina);
    
    public void delete(Rutina rutina);
    
    public Rutina getRutina(Rutina rutina);
}
