
package com.proyecto.service;

import com.proyecto.domain.Anuncio;
import java.util.List;
import org.springframework.stereotype.Service;

public interface AnuncioService {
    public List<Anuncio> getAnuncios();
    
    public void save(Anuncio anuncio);
    
    public void delete(Anuncio anuncio);
    
    public Anuncio getAnuncio(Anuncio anuncio);
}
