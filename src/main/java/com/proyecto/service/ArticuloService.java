
package com.proyecto.service;

import com.proyecto.domain.Articulo;
import java.util.List;
import org.springframework.stereotype.Service;

public interface ArticuloService {
    public List<Articulo> getArticulos();
    
    public void save(Articulo articulo);
    
    public void delete(Articulo articulo);
    
    public Articulo getArticulo(Articulo articulo);
}
