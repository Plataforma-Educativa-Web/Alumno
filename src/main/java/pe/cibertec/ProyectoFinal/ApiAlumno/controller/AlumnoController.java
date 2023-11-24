package pe.cibertec.ProyectoFinal.ApiAlumno.controller;

import java.util.List;
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

public class AlumnoController {
    
    @Autowired
    
    private AlumnoService alumnoService;

    
    
    @GetMapping("/findAll")
    
    public ResponseEntity<List<Alumno>> findAll() {
        
        return new ResponseEntity<>(alumnoService.findAll(), HttpStatus.OK);
        
    }
    
    @GetMapping("/findByNombre/{nombre}")
    
    public ResponseEntity<Alumno> findByNombre(@PathVariable String nombre ) {
        
        return new ResponseEntity<>(alumnoService.findByNombre(nombre),HttpStatus.OK);
        
    }
    
    @GetMapping("/findByCodigoA/{codigoA}")
    
    public ResponseEntity<Alumno> findByCodigoA (@PathVariable Long codigoA) {
        
        return new ResponseEntity<>(alumnoService.findByCodigoA(codigoA), HttpStatus.OK);
        
    }
    
    
    @GetMapping("/buscarPorId/{id}")
    
    public ResponseEntity<Alumno> buscarPorId(@PathVariable Long id) {
        
        return new ResponseEntity<>(alumnoService.buscarPorId(id),HttpStatus.OK);
        
    }
    
    @PostMapping("/agregarAlumno")
    
    public ResponseEntity<Alumno> agregarAlumno(@RequestBody Alumno alumno) {
        
        return new ResponseEntity<>(alumnoService.agregarAlumno(alumno),HttpStatus.CREATED);
        
    }
    
    @PutMapping("/actualizarAlumno")
    
    public ResponseEntity<Alumno> actualizarAlumno(@RequestBody Alumno alumno) {
        
        return new ResponseEntity<>(alumnoService.actualizarAlumno(alumno),HttpStatus.OK);
        
    }
    
    @DeleteMapping("/eliminarAlumno/{id}")
    
    public void eliminarAlumno (@PathVariable Long id) {
        
        alumnoService.eliminarAlumno(id);
        
    }
    
        @GetMapping("/findById/{id}")

    public ResponseEntity<AlumnoDTO> findById(@PathVariable Long id) {

        return new ResponseEntity<>(alumnoService.findById(id), HttpStatus.OK);

    }
    
}
