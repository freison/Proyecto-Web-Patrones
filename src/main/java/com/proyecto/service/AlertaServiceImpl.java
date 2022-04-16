
package com.proyecto.service;

import com.proyecto.dao.AlertaDao;
import com.proyecto.domain.Alerta;
import com.proyecto.domain.Usuario;
import com.proyecto.dao.UsuarioDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertaServiceImpl implements AlertaService {

    @Autowired
    private AlertaDao alertaDao;
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    
    @Override
    public List<Alerta> getAlertas() {
        return (List<Alerta>) alertaDao.findAll();
    }

    @Override
    public void save(Alerta alerta) {
        Usuario usuario = alerta.getUsuario();
        usuario = usuarioDao.save(usuario);
        alerta.setUsuario(usuario);
        
        alertaDao.save(alerta);
    }

    @Override
    public void delete(Alerta alerta) {
        alertaDao.delete(alerta);
    }

    @Override
    public Alerta getAlerta(Alerta alerta) {
        return alertaDao.findById(alerta.getIdAlerta()).orElse(null);
    }
}
