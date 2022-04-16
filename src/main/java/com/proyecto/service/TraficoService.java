
package com.proyecto.service;

import com.proyecto.domain.Trafico;
import java.util.List;
import org.springframework.stereotype.Service;

public interface TraficoService {
    public List<Trafico> getTraficos();
    
    public void save(Trafico trafico);
    
    public void delete(Trafico trafico);
    
    public Trafico getTrafico(Trafico trafico);
}
