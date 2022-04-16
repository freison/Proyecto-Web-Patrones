
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
@Table(name="Alerta")
public class Alerta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_alerta")
    private long idAlerta;
    
    private String mensaje;
    private int nivel;
    
    @JoinColumn(name="id_usuario", referencedColumnName="id_usuario")
    @ManyToOne
    private Usuario usuario;
    
    public Alerta() {
        
    }

    public Alerta(long idAlerta, String mensaje, int nivel, Usuario usuario) {
        this.idAlerta = idAlerta;
        this.mensaje = mensaje;
        this.nivel = nivel;
        this.usuario = usuario;
    }

    
}
