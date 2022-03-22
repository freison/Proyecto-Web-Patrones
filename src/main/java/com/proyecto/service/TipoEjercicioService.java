
package com.proyecto.service;

import com.proyecto.domain.TipoEjercicio;
import java.util.List;

public interface TipoEjercicioService {
    public List<TipoEjercicio> getTiposEjercicio();
    
    public void save(TipoEjercicio tipoEjercicio);
    
    public void delete(TipoEjercicio tipoEjercicio);
    
    public TipoEjercicio getTipoEjercicio(TipoEjercicio tipoEjercicio);
}
