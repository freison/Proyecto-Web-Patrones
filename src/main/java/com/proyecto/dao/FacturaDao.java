
package com.proyecto.dao;

import com.proyecto.domain.Factura;
import org.springframework.data.repository.CrudRepository;

public interface FacturaDao extends CrudRepository<Factura, Long> {
    
}
