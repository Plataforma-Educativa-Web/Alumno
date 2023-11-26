package pe.cibertec.ProyectoFinal.ApiAlumno.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ProyectoFinal.ApiAlumno.dto.AlumnoDTO;

import pe.cibertec.ProyectoFinal.ApiAlumno.entity.Alumno;

import pe.cibertec.ProyectoFinal.ApiAlumno.service.AlumnoService;

@RestController
@RequestMapping("/api/v1/alumno")
@Slf4j

public class AlumnoController {

    @Autowired

    private AlumnoService alumnoService;

    @GetMapping("/findAll")

    public ResponseEntity<List<Alumno>> findAll() {

        try {
            log.info("Obteniendo todos los alumnos");
            return new ResponseEntity<>(alumnoService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al obtener todos los alumnos: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/findByNombre/{nombre}")

    public ResponseEntity<Alumno> findByNombre(@PathVariable String nombre) {

        try {
            log.info("Buscando alumno por nombre: {}", nombre);
            return new ResponseEntity<>(alumnoService.findByNombre(nombre), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al buscar alumno por nombre '{}': {}", nombre, e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/findByCodigoA/{codigoA}")

    public ResponseEntity<Alumno> findByCodigoA(@PathVariable Long codigoA) {

        try {
            log.info("Buscando alumno por códigoA: {}", codigoA);
            return new ResponseEntity<>(alumnoService.findByCodigoA(codigoA), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al buscar alumno por códigoA '{}': {}", codigoA, e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/buscarPorId/{id}")

    public ResponseEntity<Alumno> buscarPorId(@PathVariable Long id) {

        try {
            log.info("Buscando alumno por ID: {}", id);
            return new ResponseEntity<>(alumnoService.buscarPorId(id), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al buscar alumno por ID '{}': {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/agregarAlumno")

    public ResponseEntity<Alumno> agregarAlumno(@RequestBody Alumno alumno) {

        try {
            log.info("Agregando nuevo alumno");
            return new ResponseEntity<>(alumnoService.agregarAlumno(alumno), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error al agregar nuevo alumno: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/actualizarAlumno")

    public ResponseEntity<Alumno> actualizarAlumno(@RequestBody Alumno alumno) {

        try {
            log.info("Actualizando alumno con ID: {}", alumno.getId());
            return new ResponseEntity<>(alumnoService.actualizarAlumno(alumno), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al actualizar alumno con ID '{}': {}", alumno.getId(), e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/eliminarAlumno/{id}")

    public void eliminarAlumno(@PathVariable Long id) {

        try {
            log.info("Eliminando alumno con ID: {}", id);
            alumnoService.eliminarAlumno(id);
        } catch (Exception e) {
            log.error("Error al eliminar alumno con ID '{}': {}", id, e.getMessage());
        }

    }

    @GetMapping("/findById/{id}")

    public ResponseEntity<AlumnoDTO> findById(@PathVariable Long id) {

        try {
            log.info("Buscando alumno por ID: {}", id);
            return new ResponseEntity<>(alumnoService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al buscar alumno por ID '{}': {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
