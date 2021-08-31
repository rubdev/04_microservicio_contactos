package dev.ruben._microservicio_contactos.service;

import dev.ruben._microservicio_contactos.dbaccess.entity.Contacto;
import dev.ruben._microservicio_contactos.dbaccess.repository.ContactosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    ContactosRepository contactosRepository;

    @Override
    public boolean agregarContacto(Contacto contacto) {
        if (contacto != null) {
            contactosRepository.save(contacto);
            return true;
        }
        return false;
    }

    @Override
    public List<Contacto> recuperarContactos() {
        return contactosRepository.findAll();
    }

    @Override
    public void actualizarContacto(Contacto contacto) {
        contactosRepository.save(contacto);
    }

    @Override
    public boolean eliminarContacto(Integer idContacto) {
        contactosRepository.deleteById(idContacto);
        return true;
    }

    @Override
    public Contacto buscarContacto(Integer idContacto) {
        return contactosRepository.findById(idContacto).orElse(null);
    }
}
