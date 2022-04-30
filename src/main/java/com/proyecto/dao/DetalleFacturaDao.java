
package com.proyecto.dao;

import com.proyecto.domain.DetalleFactura;
import org.springframework.data.repository.CrudRepository;

public interface DetalleFacturaDao extends CrudRepository<DetalleFactura, Long> {
    
}
