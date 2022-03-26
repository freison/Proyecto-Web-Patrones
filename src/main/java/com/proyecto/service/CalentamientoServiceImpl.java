
package com.proyecto.service;

import com.proyecto.dao.CalentamientoDao;
import com.proyecto.domain.Calentamiento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalentamientoServiceImpl implements CalentamientoService {

    @Autowired
    private CalentamientoDao calentamientoDao;
    
    
    @Override
    public List<Calentamiento> getCalentamientos() {
        return (List<Calentamiento>) calentamientoDao.findAll();
    }

    @Override
    public void save(Calentamiento calentamiento) {
        calentamientoDao.save(calentamiento);
    }

    @Override
    public void delete(Calentamiento calentamiento) {
        calentamientoDao.delete(calentamiento);
    }

    @Override
    public Calentamiento getCalentamiento(Calentamiento calentamiento) {
        return calentamientoDao.findById(calentamiento.getIdCalentamiento()).orElse(null);
    }
}
