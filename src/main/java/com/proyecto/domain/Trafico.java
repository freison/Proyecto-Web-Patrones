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
@Table(name = "Reporte_Trafico")
public class Trafico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reporte_trafico")
    private long idTrafico;

    private String descripcion;
    private String hora;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuario;

    public Trafico() {

    }

    public Trafico(long idTrafico, String descripcion, String hora, Usuario usuario) {
        this.idTrafico = idTrafico;
        this.descripcion = descripcion;
        this.hora = hora;
        this.usuario = usuario;
    }

    

    

}
