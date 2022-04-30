
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
@Table(name="detallefactura")
public class DetalleFactura implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_detalle_factura")
    private long idDetalleFactura;
    
    
    @JoinColumn(name="id_articulo", referencedColumnName="id_articulo")
    @ManyToOne
    private Articulo Articulo;
    
    @JoinColumn(name="id_factura", referencedColumnName="id_factura")
    @ManyToOne
    private Factura Factura;
    
    public DetalleFactura() {
        
    }

    public DetalleFactura(long idDetalleFactura, Articulo Articulo, Factura Factura) {
        this.idDetalleFactura = idDetalleFactura;
        this.Articulo = Articulo;
        this.Factura = Factura;
    }
    
    
}
