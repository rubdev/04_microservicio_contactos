package dev.ruben._microservicio_contactos;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.ruben._microservicio_contactos.dbaccess.entity.Contacto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
class ApplicationTests {

	@Autowired
	MockMvc mockMvc;

	private static int ID_PRUEBAS = 531;


	@Test
	void testGetContactos() throws Exception {
		assertNotNull(mockMvc
						.perform(get("/contactos"))
						.andDo(print()));
	}

	@Test
	void testGetContactosPorId() throws Exception {
		assertNotNull(mockMvc
						.perform(get("/contactos/" + ID_PRUEBAS))
						.andDo(print()));
	}

	@Test
	void testPostContacto() throws Exception {
		String content = "{\"nombre\": \"RUBÉN\",\"email\": \"\"dev.ruben@outlook.es\",\"edad\": \"26\"}";
		assertNotNull(mockMvc.perform(MockMvcRequestBuilders.post("/contactos")
											  .content(content)
											  .contentType(MediaType.APPLICATION_JSON)
											  .accept(MediaType.APPLICATION_JSON)
					 )
		);

	}

	@Test
	void testDeleteContactoPorId() throws Exception {
		assertNotNull(mockMvc
						.perform(delete("/contactos/" + ID_PRUEBAS))
						.andDo(print()));
	}


	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
