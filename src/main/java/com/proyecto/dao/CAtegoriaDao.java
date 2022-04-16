
package com.proyecto.dao;

import com.proyecto.domain.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaDao extends CrudRepository<Categoria, Long> {
    
}
