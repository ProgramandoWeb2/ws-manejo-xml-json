package pe.edu.cibertec.ws_manejo_xml_json;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.cibertec.ws_manejo_xml_json.model.Alumno;
import pe.edu.cibertec.ws_manejo_xml_json.service.FileService;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class WsManejoXmlJsonApplication implements CommandLineRunner {
	private final FileService fileService;

	public static void main(String[] args) {
		SpringApplication.run(WsManejoXmlJsonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Alumno alumno = new Alumno("Luis", 30, "Lima");
		//fileService.crearXML(alumno);
		Alumno alumnoXML =  fileService.leerXML();
		log.info("Alumno XML: " + alumnoXML.toString());

		fileService.crearJSON(alumno);
		Alumno alumnoJSON = fileService.leerJSON();
		log.info("Alumno JSON: " + alumnoJSON.toString());
	}
}
