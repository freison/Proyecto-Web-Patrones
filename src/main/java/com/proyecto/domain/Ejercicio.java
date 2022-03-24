
package com.proyecto.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Ejercicio")
public class Ejercicio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEjercicio;
    
    private String descripcion;
    
    @JoinColumn(name="id_tipo_ejercicio", referencedColumnName="id_tipo_ejercicio")
    @ManyToOne
    private TipoEjercicio tipoEjercicio;
    
    public Ejercicio() {
        
    }

    public Ejercicio(String descripcion, TipoEjercicio tipoEjercicio) {
        this.descripcion = descripcion;
        this.tipoEjercicio = tipoEjercicio;
    }
}
