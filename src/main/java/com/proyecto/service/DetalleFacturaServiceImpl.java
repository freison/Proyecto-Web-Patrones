
package com.proyecto.service;

import com.proyecto.dao.DetalleFacturaDao;
import com.proyecto.domain.DetalleFactura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService {

    @Autowired
    private DetalleFacturaDao detallefacturaDao;
    
    
    @Override
    public List<DetalleFactura> getDetalleFacturas() {
        return (List<DetalleFactura>) detallefacturaDao.findAll();
    }

    @Override
    public void save(DetalleFactura detallefactura) {
        detallefacturaDao.save(detallefactura);
    }

    @Override
    public void delete(DetalleFactura detallefactura) {
        detallefacturaDao.delete(detallefactura);
    }

    @Override
    public DetalleFactura getDetalleFactura(DetalleFactura detallefactura) {
        return detallefacturaDao.findById(detallefactura.getIdDetalleFactura()).orElse(null);
    }
}
