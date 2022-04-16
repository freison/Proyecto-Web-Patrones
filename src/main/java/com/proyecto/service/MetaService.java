
package com.proyecto.service;

import com.proyecto.domain.Meta;
import java.util.List;
import org.springframework.stereotype.Service;

public interface MetaService {
    public List<Meta> getMetas();
    
    public void save(Meta meta);
    
    public void delete(Meta meta);
    
    public Meta getMeta(Meta meta);
}
