
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
@Table(name="Sugerencia_Lugar")
public class SugerenciaLugar implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_sugerencia_lugar")
    private Long idSugerencia;
    
    private String direccion;
    
    @JoinColumn(name="id_usuario", referencedColumnName="id_usuario")
    @ManyToOne
    private Usuario usuario;
    
    public SugerenciaLugar(){
        
    }

    public SugerenciaLugar(String direccion, Usuario usuario) {
        this.direccion = direccion;
        this.usuario = usuario;
    }
}
