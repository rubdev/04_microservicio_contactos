package dev.ruben._microservicio_contactos.dbaccess.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Clase de persistencia para la tabla "contactos" de la BD "04_microservicio_contactos"
 */
@Entity
@Table(name = "MCR_CONTACTOS")
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContacto")
    private Integer idContacto;
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @Column(name = "edad", nullable = false, length = 10)
    private int edad;

    public Contacto() {

    }

    public Contacto(Integer idContacto, String nombre, String email, int edad) {
        this.idContacto = idContacto;
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    public Contacto(String nombre, String email, int edad) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
