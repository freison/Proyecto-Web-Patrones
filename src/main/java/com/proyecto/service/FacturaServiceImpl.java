
package com.proyecto.service;

import com.proyecto.dao.FacturaDao;
import com.proyecto.domain.Factura;
import com.proyecto.domain.Usuario;
import com.proyecto.dao.UsuarioDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaDao facturaDao;
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    
    @Override
    public List<Factura> getFacturas() {
        return (List<Factura>) facturaDao.findAll();
    }

    @Override
    public void save(Factura factura) {
        Usuario usuario = factura.getUsuario();
        usuario = usuarioDao.save(usuario);
        factura.setUsuario(usuario);
        
        facturaDao.save(factura);
    }

    @Override
    public void delete(Factura factura) {
        facturaDao.delete(factura);
    }

    @Override
    public Factura getFactura(Factura factura) {
        return facturaDao.findById(factura.getIdFactura()).orElse(null);
    }
}
