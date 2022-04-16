
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
@Table(name="Meta")
public class Meta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_meta")
    private long idMeta;
    
    private String descripcion;
    
    @JoinColumn(name="id_usuario", referencedColumnName="id_usuario")
    @ManyToOne
    private Usuario usuario;
    
    public Meta() {
        
    }

    public Meta(long idMeta, String descripcion) {
        this.idMeta = idMeta;
        this.descripcion = descripcion;
    }

    
}
