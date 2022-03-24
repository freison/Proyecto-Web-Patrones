
package com.proyecto.dao;

import com.proyecto.domain.Ejercicio;
import org.springframework.data.repository.CrudRepository;

public interface EjercicioDao extends CrudRepository<Ejercicio, Long> {
    
}
