
package com.proyecto.dao;

import com.proyecto.domain.Anuncio;
import org.springframework.data.repository.CrudRepository;

public interface AnuncioDao extends CrudRepository<Anuncio, Long> {
    
}
