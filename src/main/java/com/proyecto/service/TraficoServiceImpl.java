
package com.proyecto.service;

import com.proyecto.dao.TraficoDao;
import com.proyecto.domain.Trafico;
import com.proyecto.domain.Usuario;
import com.proyecto.dao.UsuarioDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraficoServiceImpl implements TraficoService {

    @Autowired
    private TraficoDao traficoDao;
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    
    @Override
    public List<Trafico> getTraficos() {
        return (List<Trafico>) traficoDao.findAll();
    }

    @Override
    public void save(Trafico trafico) {
        Usuario usuario = trafico.getUsuario();
        usuario = usuarioDao.save(usuario);
        trafico.setUsuario(usuario);
        
        traficoDao.save(trafico);
    }

    @Override
    public void delete(Trafico trafico) {
        traficoDao.delete(trafico);
    }

    @Override
    public Trafico getTrafico(Trafico trafico) {
        return traficoDao.findById(trafico.getIdTrafico()).orElse(null);
    }
}
