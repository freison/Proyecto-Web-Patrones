
package com.proyecto.domain;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name="Factura")
public class Factura implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_factura")
    private long idFactura;
    
    @JoinColumn(name="id_usuario", referencedColumnName="id_usuario")
    @ManyToOne
    private Usuario usuario;
    
    private Date fecha;
    private Double total;
    private int estado;
    
    public Factura() {
        
    }

    public Factura(long idFactura, Usuario usuario, Date fecha, Double total, int estado) {
        this.idFactura = idFactura;
        this.usuario = usuario;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
    }
    
}
