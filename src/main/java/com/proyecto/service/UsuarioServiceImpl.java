
package com.proyecto.service;

import com.proyecto.dao.EmpresaDao;
import com.proyecto.dao.RolDao;
import com.proyecto.dao.UsuarioDao;
import com.proyecto.domain.Empresa;
import com.proyecto.domain.Rol;
import com.proyecto.domain.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired EmpresaDao empresaDao;
    
    @Autowired RolDao rolDao;
    
    
    @Override
    public List<Usuario> getUsuarios() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    public void save(Usuario usuario) {
        System.out.println("Start");
        Empresa empresa = usuario.getEmpresa();
        empresa = (Long)empresa.getIdEmpresa() != null ? empresa : empresaDao.save(empresa);
        usuario.setEmpresa(empresa);
        
        System.out.println(usuario.getEmpresa());
        
        Rol rol = usuario.getRol();
        rol = (Long)rol.getIdRol() != null ? rol: rolDao.save(rol);
        usuario.setRol(rol);
        
        System.out.println(usuario.getRol());    
        
        usuarioDao.save(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }
}
