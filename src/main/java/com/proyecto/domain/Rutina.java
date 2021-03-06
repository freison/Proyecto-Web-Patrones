
package com.proyecto.domain;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name="Rutina")
public class Rutina implements Serializable {
    
    private static final long SerialVersinoUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_rutina")
    private Long idRutina;
    
    private String descripcion;
    
    @JoinColumn(name="id_usuario", referencedColumnName="id_usuario")
    @ManyToOne
    private Usuario usuario;
    
    @JoinColumn(name="id_calentamiento",referencedColumnName="id_calentamiento")
    @ManyToOne
    private Calentamiento calentamiento;
    
    public Rutina(){
        
    }

    public Rutina(Long idRutina, String descripcion, Usuario usuario, Calentamiento calentamiento) {
        this.idRutina = idRutina;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.calentamiento = calentamiento;
    }

    
}