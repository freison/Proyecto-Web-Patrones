
package com.proyecto.dao;

import com.proyecto.domain.Empresa;
import org.springframework.data.repository.CrudRepository;

public interface EmpresaDao extends CrudRepository<Empresa, Long> {
    
}
