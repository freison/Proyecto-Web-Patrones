
package com.proyecto.service;

import com.proyecto.domain.DetalleFactura;
import java.util.List;
import org.springframework.stereotype.Service;

public interface DetalleFacturaService {
    public List<DetalleFactura> getDetalleFacturas();
    
    public void save(DetalleFactura detallefactura);
    
    public void delete(DetalleFactura detallefactura);
    
    public DetalleFactura getDetalleFactura(DetalleFactura detallefactura);
}
