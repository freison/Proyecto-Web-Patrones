
package com.proyecto.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
@Entity
@Table(name="Usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Long idUsuario;
    
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String nombreUsuario;
    private String clave;
    private String correo;
    private String fechaNacimiento; /**------LocalDate?-----**/
    
    @JoinColumn(name="id_empresa", referencedColumnName="id_empresa")
    @ManyToOne
    private Empresa empresa;
    
    @JoinColumn(name="id_rol", referencedColumnName="id_rol")
    @ManyToOne
    private Rol rol;
    
    public Usuario(){
        
    }

    public Usuario(String nombre, String primerApellido, String segundoApellido, String nombreUsuario, String clave, String correo, String fechaNacimiento, Empresa empresa, Rol rol) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.empresa = empresa;
        this.rol = rol;
    }
}
