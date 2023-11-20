package pe.cibertec.ProyectoFinal.ApiAlumno.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.ProyectoFinal.ApiAlumno.dao.AlumnoRepository;
import pe.cibertec.ProyectoFinal.ApiAlumno.entity.Alumno;
import pe.cibertec.ProyectoFinal.ApiAlumno.exception.EntityNotFoundException;
import pe.cibertec.ProyectoFinal.ApiAlumno.service.AlumnoService;

@Service

public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    
    private AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> findAll() {
        
        return (List<Alumno>) alumnoRepository.findAll();
        
    }

     @Override
    public Alumno findByNombre(String nombre) {
       
        return alumnoRepository.findByNombre(nombre).orElseThrow(() -> new EntityNotFoundException("Alumno no encontrado con el nombre "+nombre.toString()));
        
    }
    
    @Override
    public Alumno buscarPorId(Long id) {
        
        return alumnoRepository.findById(id).orElseThrow(()->
          new EntityNotFoundException("Alumno no encontrado con el id "+id.toString()));
        
    }

    
    
    @Override
    public Alumno agregarAlumno(Alumno alumno) {
        
        return alumnoRepository.save(alumno);
        
    }

    @Override
    public Alumno actualizarAlumno(Alumno alumno) {
       
        var AlumnoF = alumnoRepository.findById(alumno.getId()).get();
        AlumnoF.setNombre(alumno.getNombre());
        AlumnoF.setApellido(alumno.getApellido());
        AlumnoF.setSexo(alumno.getSexo());
        AlumnoF.setEmail(alumno.getEmail());
        AlumnoF.setEdad(alumno.getEdad());
        AlumnoF.setCelular(alumno.getCelular());
        
        return alumnoRepository.save(AlumnoF);
        
    }

    @Override
    public void eliminarAlumno(Long id) {
        
        var AlumnoF = alumnoRepository.findById(id).get();
        
       alumnoRepository.delete(AlumnoF);
        
        
    } 
}

