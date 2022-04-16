
package com.proyecto.service;

import com.proyecto.domain.Articulo;
import java.util.ArrayList;
import java.util.List;
import java.util.Hashtable;


public interface CarritoService {
    public Hashtable<Articulo, Long> lista = new Hashtable<Articulo, Long>();
    
    public List<Articulo> listaArticulos = new ArrayList<Articulo>();
    
    public Hashtable<Articulo, Long> getArticulos();
    
    public void save(Articulo articulo);
    
    public void delete(Articulo articulo);
    
    public Articulo getArticulo(Articulo articulo);
}
