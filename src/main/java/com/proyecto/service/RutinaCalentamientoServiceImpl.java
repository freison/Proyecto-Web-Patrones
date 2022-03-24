
package com.proyecto.service;

import com.proyecto.dao.RutinaDao;
import com.proyecto.domain.Calentamiento;
import com.proyecto.domain.Rutina;
import com.proyecto.domain.RutinaCalentamiento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.dao.RutinaCalentamientoDao;
import com.proyecto.dao.CalentamientoDao;

@Service
public class RutinaCalentamientoServiceImpl implements RutinaCalentamientoService {

    @Autowired
    RutinaCalentamientoDao rutinaCalentamientoDao;
    
    @Autowired
    RutinaDao rutinaDao;
    
    @Autowired
    CalentamientoDao calentamientoDao;
    
    @Override
    public List<RutinaCalentamiento> getRutinasCalentamientos() {
        return (List<RutinaCalentamiento>) rutinaCalentamientoDao.findAll();
    }

    @Override
    public void save(RutinaCalentamiento rutinaCalentamiento) {
        Rutina rutina = rutinaCalentamiento.getRutina();
        rutina = rutinaDao.save(rutina);
        rutinaCalentamiento.setRutina(rutina);
        
        Calentamiento calentamiento = rutinaCalentamiento.getCalentamiento();
        calentamiento = calentamientoDao.save(calentamiento);
        rutinaCalentamiento.setCalentamiento(calentamiento);
        
        rutinaCalentamientoDao.save(rutinaCalentamiento);
    }

    @Override
    public void delete(RutinaCalentamiento rutinaCalentamiento) {
        rutinaCalentamientoDao.delete(rutinaCalentamiento);
    }

    @Override
    public RutinaCalentamiento getRutinaCalentamiento(RutinaCalentamiento rutinaCalentamiento) {
        return rutinaCalentamientoDao.findById(rutinaCalentamiento.getIdRutinaCalentamiento()).orElse(null);
    }
}
