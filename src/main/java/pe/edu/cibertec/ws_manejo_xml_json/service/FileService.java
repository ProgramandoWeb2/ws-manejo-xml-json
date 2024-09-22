package pe.edu.cibertec.ws_manejo_xml_json.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ws_manejo_xml_json.model.Alumno;

import java.io.File;
import java.io.StringWriter;
@Slf4j
@Service
public class FileService {

    private static final String XML_FILE_PATH = "alumno.xml";
    private static final String JSON_FILE_PATH = "alumno.json";

    public void crearXML(Alumno alumno) throws  Exception{
        JAXBContext context = JAXBContext.newInstance(Alumno.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //Escribir en el archivo XML
        marshaller.marshal(alumno, new File(XML_FILE_PATH));
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(alumno, stringWriter);
        log.info("XML: " + stringWriter);
    }

    public Alumno leerXML() throws  Exception{
        JAXBContext context = JAXBContext.newInstance(Alumno.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Alumno) unmarshaller.unmarshal(new File(XML_FILE_PATH));
    }

    public void crearJSON(Alumno alumno) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File(JSON_FILE_PATH), alumno);
    }

    public Alumno leerJSON () throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(JSON_FILE_PATH), Alumno.class);
    }
}
