
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
@Table(name="Rutina_Ejercicio")
public class RutinaEjercicio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRutinaEjercicio;
    
    @JoinColumn(name="id_rutina", referencedColumnName="id_rutina")
    @ManyToOne
    private Rutina rutina;
    
    @JoinColumn(name="id_ejercicio", referencedColumnName="id_ejercicio")
    @ManyToOne
    private Ejercicio ejercicio;
    
    public RutinaEjercicio() {
        
    }

    public RutinaEjercicio(Rutina rutina, Ejercicio ejercicio) {
        this.rutina = rutina;
        this.ejercicio = ejercicio;
    }
}
