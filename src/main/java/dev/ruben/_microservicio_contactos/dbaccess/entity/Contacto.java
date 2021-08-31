package dev.ruben._microservicio_contactos.dbaccess.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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

    public Contacto(int idContacto, String nombre, String email, int edad) {
        this.idContacto = idContacto;
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacto contactos = (Contacto) o;
        return idContacto == contactos.idContacto && edad == contactos.edad && Objects.equals(nombre, contactos.nombre) && Objects.equals(email, contactos.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContacto, nombre, email, edad);
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "idContacto=" + idContacto +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", edad=" + edad +
                '}';
    }
}
