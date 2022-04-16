
package com.proyecto.service;

import com.proyecto.domain.Alerta;
import java.util.List;
import org.springframework.stereotype.Service;

public interface AlertaService {
    public List<Alerta> getAlertas();
    
    public void save(Alerta alerta);
    
    public void delete(Alerta alerta);
    
    public Alerta getAlerta(Alerta alerta);
}
