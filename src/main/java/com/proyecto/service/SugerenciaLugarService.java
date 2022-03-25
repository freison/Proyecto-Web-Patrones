
package com.proyecto.service;

import com.proyecto.domain.SugerenciaLugar;
import java.util.List;

public interface SugerenciaLugarService {
    public List<SugerenciaLugar> getSugerenciaLugares();
    
    public void save(SugerenciaLugar sugerenciaLugar);
    
    public void delete(SugerenciaLugar sugerenciaLugar);
    
    public SugerenciaLugar getSugerenciaLugar(SugerenciaLugar sugerenciaLugar);
}
