
package com.proyecto.service;

import com.proyecto.dao.EjercicioDao;
import com.proyecto.dao.TipoEjercicioDao;
import com.proyecto.domain.Ejercicio;
import com.proyecto.domain.TipoEjercicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EjercicioServiceImpl implements EjercicioService {
    
    @Autowired
    private EjercicioDao ejercicioDao;
    
    @Autowired
    private TipoEjercicioDao tipoEjercicioDao;
    
    @Override
    public List<Ejercicio> getEjercicios() {
        return (List<Ejercicio>) ejercicioDao.findAll();
    }

    @Override
    public void save(Ejercicio ejercicio) {
        TipoEjercicio tipoEjercicio = ejercicio.getTipoEjercicio();
        tipoEjercicio = tipoEjercicioDao.save(tipoEjercicio);
        ejercicio.setTipoEjercicio(tipoEjercicio);
        
        ejercicioDao.save(ejercicio);
    }

    @Override
    public void delete(Ejercicio ejercicio) {
        ejercicioDao.delete(ejercicio);
    }

    @Override
    public Ejercicio getEjercicio(Ejercicio ejercicio) {
        return ejercicioDao.findById(ejercicio.getIdEjercicio()).orElse(null);
    }
}
