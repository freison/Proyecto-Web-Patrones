
package com.proyecto.service;

import com.proyecto.dao.AnuncioDao;
import com.proyecto.domain.Anuncio;
import com.proyecto.domain.Usuario;
import com.proyecto.dao.UsuarioDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnuncioServiceImpl implements AnuncioService {

    @Autowired
    private AnuncioDao anuncioDao;
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    
    @Override
    public List<Anuncio> getAnuncios() {
        return (List<Anuncio>) anuncioDao.findAll();
    }

    @Override
    public void save(Anuncio anuncio) {
        Usuario usuario = anuncio.getUsuario();
        usuario = usuarioDao.save(usuario);
        anuncio.setUsuario(usuario);
        
        anuncioDao.save(anuncio);
    }

    @Override
    public void delete(Anuncio anuncio) {
        anuncioDao.delete(anuncio);
    }

    @Override
    public Anuncio getAnuncio(Anuncio anuncio) {
        return anuncioDao.findById(anuncio.getIdAnuncio()).orElse(null);
    }
}
