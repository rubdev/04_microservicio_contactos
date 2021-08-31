package dev.ruben._microservicio_contactos.service;

import dev.ruben._microservicio_contactos.dbaccess.entity.Contacto;

import java.util.List;

public interface AgendaService {

    boolean agregarContacto(Contacto contacto);
    List<Contacto> recuperarContactos();
    void actualizarContacto(Contacto contacto);
    boolean eliminarContacto(Integer idContacto);
    Contacto buscarContacto(Integer idContacto);

}
