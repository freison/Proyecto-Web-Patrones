
package com.proyecto.service;

import com.proyecto.domain.Factura;
import java.util.List;
import org.springframework.stereotype.Service;

public interface FacturaService {
    public List<Factura> getFacturas();
    
    public void save(Factura factura);
    
    public void delete(Factura factura);
    
    public Factura getFactura(Factura factura);
}
