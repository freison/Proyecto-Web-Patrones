
package com.proyecto.service;

import com.proyecto.domain.Categoria;
import java.util.List;
import org.springframework.stereotype.Service;

public interface CategoriaService {
    public List<Categoria> getCategorias();
    
    public void save(Categoria categoria);
    
    public void delete(Categoria categoria);
    
    public Categoria getCategoria(Categoria categoria);
}
