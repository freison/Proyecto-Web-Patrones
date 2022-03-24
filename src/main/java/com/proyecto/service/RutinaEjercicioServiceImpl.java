
package com.proyecto.service;

import com.proyecto.dao.EjercicioDao;
import com.proyecto.dao.RutinaDao;
import com.proyecto.dao.RutinaEjercicioDao;
import com.proyecto.domain.Ejercicio;
import com.proyecto.domain.Rutina;
import com.proyecto.domain.RutinaEjercicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutinaEjercicioServiceImpl implements RutinaEjercicioService {

    @Autowired
    RutinaEjercicioDao rutinaEjercicioDao;
    
    @Autowired
    RutinaDao rutinaDao;
    
    @Autowired
    EjercicioDao ejercicioDao;
    
    @Override
    public List<RutinaEjercicio> getRutinasEjercicios() {
        return (List<RutinaEjercicio>) rutinaEjercicioDao.findAll();
    }

    @Override
    public void save(RutinaEjercicio rutinaEjercicio) {
        Rutina rutina = rutinaEjercicio.getRutina();
        rutina = rutinaDao.save(rutina);
        rutinaEjercicio.setRutina(rutina);
        
        Ejercicio ejercicio = rutinaEjercicio.getEjercicio();
        ejercicio = ejercicioDao.save(ejercicio);
        rutinaEjercicio.setEjercicio(ejercicio);
        
        rutinaEjercicioDao.save(rutinaEjercicio);
    }

    @Override
    public void delete(RutinaEjercicio rutinaEjercicio) {
        rutinaEjercicioDao.delete(rutinaEjercicio);
    }

    @Override
    public RutinaEjercicio getRutinaEjercicio(RutinaEjercicio rutinaEjercicio) {
        return rutinaEjercicioDao.findById(rutinaEjercicio.getIdRutinaEjercicio()).orElse(null);
    }
}
