
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
@Table(name="Categoria")
public class Categoria implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private long idCategoria;
    
    private String descripcion;
    private int activo;
    
    public Categoria() {
        
    }

    public Categoria(long idCategoria, String descripcion, int activo) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    

    
}
