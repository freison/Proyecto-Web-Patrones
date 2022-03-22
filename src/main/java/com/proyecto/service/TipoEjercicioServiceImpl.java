
package com.proyecto.service;

import com.proyecto.dao.TipoEjercicioDao;
import com.proyecto.domain.TipoEjercicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class TipoEjercicioServiceImpl implements TipoEjercicioService {

    @Autowired
    private TipoEjercicioDao tipoEjercicioDao;
    
    @Override
    public List<TipoEjercicio> getTiposEjercicio() {
        return (List<TipoEjercicio>) tipoEjercicioDao.findAll();
    }

    @Override
    public void save(TipoEjercicio tipoEjercicio) {
        tipoEjercicioDao.save(tipoEjercicio);
    }

    @Override
    public void delete(TipoEjercicio tipoEjercicio) {
        tipoEjercicioDao.delete(tipoEjercicio);
    }

    @Override
    public TipoEjercicio getTipoEjercicio(TipoEjercicio tipoEjercicio) {
        return tipoEjercicioDao.findById(tipoEjercicio.getIdTiposEjercicio()).orElse(null);
    }
    
}
