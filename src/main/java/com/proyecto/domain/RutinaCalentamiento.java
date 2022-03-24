
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
@Table(name="Rutina_Calentamiento")
public class RutinaCalentamiento implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRutinaCalentamiento;
    
    @JoinColumn(name="id_rutina", referencedColumnName="id_rutina")
    @ManyToOne
    private Rutina rutina;
    
    @JoinColumn(name="id_calentamiento", referencedColumnName="id_calentamiento")
    @ManyToOne
    private Calentamiento calentamiento;
    
    public RutinaCalentamiento() {
        
    }

    public RutinaCalentamiento(Rutina rutina, Calentamiento calentamiento) {
        this.rutina = rutina;
        this.calentamiento = calentamiento;
    }
}
