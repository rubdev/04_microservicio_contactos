package dev.ruben._microservicio_contactos.dbaccess.repository;

import dev.ruben._microservicio_contactos.dbaccess.entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de querys para la entidad "Contacto"
 */
@Repository
public interface ContactosRepository extends JpaRepository<Contacto, Integer> {

    Contacto findByEmail(String email);

}
