
package com.proyecto.service;

import com.proyecto.domain.Articulo;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    private ArticuloService articuloService;

    @Override
    public Hashtable<Articulo, Long> getArticulos() {
        return lista;
    }

    @Override
    public void save(Articulo articulo) {
        boolean encontrado = false;
        articulo = articuloService.getArticulo(articulo);

        for (var a : lista.entrySet()) {
            if (Objects.equals(a.getKey().getIdArticulo(), articulo.getIdArticulo())) {
                a.setValue(a.getValue()+1);
                // a.setExistencias(a.getExistencias() + 1);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println(articulo);
            // articulo.setExistencias(1);
            // listaArticulos.add(articulo);
            lista.put(articulo, (long)1);
        }
    }

    @Override
    public void delete(Articulo articulo) {
        int indice = -1;
        boolean flag = false;
        
        articulo = articuloService.getArticulo(articulo);
        
        for (var a : lista.entrySet()) {
            if (!flag) {
                indice++;
                if (Objects.equals(a.getKey().getIdArticulo(), articulo.getIdArticulo())) {
                    a.setValue(a.getValue()-1);
                }
            }
        }

//        listaArticulos.get(indice).
//                setExistencias(
//                listaArticulos.
//                get(indice).
//                getExistencias() - 1);
        
        
//        if(listaArticulos.get(indice).getExistencias()<=0){
//            listaArticulos.remove(indice);
//        }
        
        System.out.println(articulo);

        if(lista.get(articulo)<=0){
            lista.remove(articulo);
        }

    }

    @Override
    public Articulo getArticulo(Articulo articulo) {
        for (var a : lista.entrySet()) {
            if (Objects.equals(a.getKey().getIdArticulo(), articulo.getIdArticulo())) {
                return a.getKey();
            }
        }
        return null;
    }
}
