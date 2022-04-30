
package com.proyecto.service;

import com.proyecto.dao.ArticuloDao;
import com.proyecto.dao.CategoriaDao;
import com.proyecto.domain.Articulo;
import com.proyecto.domain.Calentamiento;
import com.proyecto.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    private ArticuloDao articuloDao;
    
    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    public List<Articulo> getArticulos() {
        return (List<Articulo>) articuloDao.findAll();
    }

    @Override
    public void save(Articulo articulo) {    
        
        Categoria categoria = articulo.getCategoria();
        categoria = categoriaDao.save(categoria);
        articulo.setCategoria(categoria);
        
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
