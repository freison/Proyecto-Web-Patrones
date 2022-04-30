
package com.proyecto.service;

import com.proyecto.dao.CalentamientoDao;
import com.proyecto.dao.RutinaDao;
import com.proyecto.dao.UsuarioDao;
import com.proyecto.domain.Calentamiento;
import com.proyecto.domain.Rutina;
import com.proyecto.domain.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutinaServiceImpl implements RutinaService {

    @Autowired
    private RutinaDao rutinaDao;
    
    @Autowired
    private UsuarioDao usuarioDao; 
    
    @Autowired
    private CalentamientoDao calentamientoDao; 
    
    @Override
    public List<Rutina> getRutinas() {
        return (List<Rutina>) rutinaDao.findAll();
    }

    @Override
    public void save(Rutina rutina) {
        Usuario usuario = rutina.getUsuario();
        usuario = usuarioDao.save(usuario);
        rutina.setUsuario(usuario);
        
        Calentamiento calentamiento = rutina.getCalentamiento();
        calentamiento = calentamientoDao.save(calentamiento);
        rutina.setCalentamiento(calentamiento);
        
        rutinaDao.save(rutina);
    }

    @Override
    public void delete(Rutina rutina) {
        rutinaDao.delete(rutina);
    }

    @Override
    public Rutina getRutina(Rutina rutina) {
        return rutinaDao.findById(rutina.getIdRutina()).orElse(null);
    }
}
