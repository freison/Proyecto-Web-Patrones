
package com.proyecto.service;

import com.proyecto.domain.Articulo;
import java.util.ArrayList;
import java.util.List;


public interface CarritoService {
    public List<Articulo> listaArticulos = new ArrayList<Articulo>();
    
    public List<Articulo> getArticulos();
    
    public void save(Articulo articulo);
    
    public void delete(Articulo articulo);
    
    public Articulo getArticulo(Articulo articulo);
}
