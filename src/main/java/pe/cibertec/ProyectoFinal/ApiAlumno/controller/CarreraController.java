package pe.cibertec.ProyectoFinal.ApiAlumno.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ProyectoFinal.ApiAlumno.entity.Carrera;
import pe.cibertec.ProyectoFinal.ApiAlumno.restClient.CarreraRestClient;

@RestController
@RequestMapping("/api/v1/carrera")
@Slf4j

public class CarreraController {

    @Autowired

    private CarreraRestClient carreraRestClient;

    @GetMapping("/findAllCarrera")

    public ResponseEntity<List<Carrera>> findAllCarrera() {

        try {
            log.info("Obteniendo todas las carreras");
            return new ResponseEntity<>(carreraRestClient.findAllCarrera(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al obtener todas las carreras: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
