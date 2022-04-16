
package com.proyecto.service;

import com.proyecto.dao.ArticuloDao;
import com.proyecto.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    private ArticuloDao articuloDao;
    
    @Override
    public List<Articulo> getArticulos() {
        return (List<Articulo>) articuloDao.findAll();
    }

    @Override
    public void save(Articulo articulo) {        
        articuloDao.save(articulo);
    }

    @Override
    public void delete(Articulo articulo) {
        articuloDao.delete(articulo);
    }

    @Override
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }
}
