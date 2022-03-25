
package com.proyecto.service;

import com.proyecto.dao.SugerenciaLugarDao;
import com.proyecto.dao.UsuarioDao;
import com.proyecto.domain.SugerenciaLugar;
import com.proyecto.domain.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SugerenciaLugarServiceImpl implements SugerenciaLugarService {

    @Autowired
    private SugerenciaLugarDao sugerenciaDao;
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    public List<SugerenciaLugar> getSugerenciaLugares() {
        return (List<SugerenciaLugar>) sugerenciaDao.findAll();
    }

    @Override
    public void save(SugerenciaLugar sugerenciaLugar) {
        Usuario usuario = sugerenciaLugar.getUsuario();
        usuario = usuarioDao.save(usuario);
        sugerenciaLugar.setUsuario(usuario);
        
        sugerenciaDao.save(sugerenciaLugar);
    }

    @Override
    public void delete(SugerenciaLugar sugerenciaLugar) {
        sugerenciaDao.delete(sugerenciaLugar);
    }
    @Override
    public SugerenciaLugar getSugerenciaLugar(SugerenciaLugar sugerenciaLugar) {
        return sugerenciaDao.findById(sugerenciaLugar.getIdSugerencia()).orElse(null);
    }
}
