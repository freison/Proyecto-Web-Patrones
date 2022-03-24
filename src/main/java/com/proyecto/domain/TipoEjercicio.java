
package com.proyecto.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Tipo_Ejercicio")
public class TipoEjercicio implements Serializable {
    private static final long SerialVersinoUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoEjercicio;
    
    private String descripcion;
    
    public TipoEjercicio(){
        
    }
    
    public TipoEjercicio(String descripcion){
        this.descripcion = descripcion;
    }
}

