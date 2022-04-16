
package com.proyecto.service;

import com.proyecto.dao.MetaDao;
import com.proyecto.domain.Meta;
import com.proyecto.domain.Usuario;
import com.proyecto.dao.UsuarioDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetaServiceImpl implements MetaService {

    @Autowired
    private MetaDao metaDao;
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    
    @Override
    public List<Meta> getMetas() {
        return (List<Meta>) metaDao.findAll();
    }

    @Override
    public void save(Meta meta) {
        Usuario usuario = meta.getUsuario();
        usuario = usuarioDao.save(usuario);
        meta.setUsuario(usuario);
        
        metaDao.save(meta);
    }

    @Override
    public void delete(Meta meta) {
        metaDao.delete(meta);
    }

    @Override
    public Meta getMeta(Meta meta) {
        return metaDao.findById(meta.getIdMeta()).orElse(null);
    }
}
