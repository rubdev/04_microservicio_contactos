package dev.ruben._microservicio_contactos.controller;

import dev.ruben._microservicio_contactos.dbaccess.entity.Contacto;
import dev.ruben._microservicio_contactos.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ContactoController {

    @Autowired
    AgendaService agendaService;

    @GetMapping(value = "contactos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contacto> getContactos() {
        return agendaService.recuperarContactos();
    }

    @GetMapping(value = "contactos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Contacto getContactos(@PathVariable(value = "id", required = true) int id) {
        return agendaService.buscarContacto(id);
    }

    @PostMapping(value = "contactos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void guardarContacto(@RequestBody(required = true) Contacto contacto) throws Exception {
        agendaService.agregarContacto(contacto);
    }

    @DeleteMapping(value = "contactos/{id}")
    public void eliminarContacto(@PathVariable(value = "id", required = true) int id) {
        agendaService.eliminarContacto(id);
    }
}
