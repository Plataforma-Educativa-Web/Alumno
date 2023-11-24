package pe.cibertec.ProyectoFinal.ApiAlumno.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.ProyectoFinal.ApiAlumno.dao.AlumnoRepository;
import pe.cibertec.ProyectoFinal.ApiAlumno.dto.AlumnoDTO;
import pe.cibertec.ProyectoFinal.ApiAlumno.entity.Alumno;
import pe.cibertec.ProyectoFinal.ApiAlumno.entity.Carrera;
import pe.cibertec.ProyectoFinal.ApiAlumno.entity.Sede;
import pe.cibertec.ProyectoFinal.ApiAlumno.exception.EntityNotFoundException;
import pe.cibertec.ProyectoFinal.ApiAlumno.service.AlumnoService;
import pe.cibertec.ProyectoFinal.ApiAlumno.restClient.CarreraRestClient;
import pe.cibertec.ProyectoFinal.ApiAlumno.restClient.SedeRestClient;

@Service

public class AlumnoServiceImpl implements AlumnoService {

    @Autowired

    private AlumnoRepository alumnoRepository;

    @Autowired

    private SedeRestClient sedeRestClient;

    @Autowired
    
    private CarreraRestClient carreraRestClient;
    
    @Override
    public List<Alumno> findAll() {

        return (List<Alumno>) alumnoRepository.findAll();

    }

    public List<Sede> findAllSede() {

        return (List<Sede>) sedeRestClient.findAllSede();

    }
    
    public List<Carrera> findAllCarrera() {
        
        return (List<Carrera>) carreraRestClient.findAllCarrera();
        
    }
    

    @Override
    public Alumno findByNombre(String nombre) {

        return alumnoRepository.findByNombre(nombre).orElseThrow(() -> new EntityNotFoundException("Alumno no encontrado con el nombre " + nombre.toString()));

    }

    @Override
    public Alumno buscarPorId(Long id) {

        return alumnoRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Alumno no encontrado con el id " + id.toString()));

    }

    @Override
    public Alumno agregarAlumno(Alumno alumno) {

        return alumnoRepository.save(alumno);

    }

    @Override
    public Alumno actualizarAlumno(Alumno alumno) {

        var AlumnoF = alumnoRepository.findById(alumno.getId()).get();
        AlumnoF.setCodigoA(alumno.getCodigoA());
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

    @Override
    public AlumnoDTO findById(Long id) {

        Alumno alumno = alumnoRepository.findById(id).get();

        Sede sede = sedeRestClient.findByCodigoS(alumno.getCodigoS());
        
        Carrera carrera = carreraRestClient.findByCodigoC(alumno.getCodigoC());

        AlumnoDTO alumnoDTO = new AlumnoDTO();

        
        alumnoDTO.setId(alumno.getId());
        alumnoDTO.setCodigoA(alumno.getCodigoA());
        alumnoDTO.setNombre(alumno.getNombre());
        alumnoDTO.setApellido(alumno.getApellido());
        alumnoDTO.setDni(alumno.getDni());
        alumnoDTO.setSexo(alumno.getSexo());
        alumnoDTO.setEmail(alumno.getEmail());
        alumnoDTO.setEdad(alumno.getEdad());
        alumnoDTO.setCelular(alumno.getCelular());
        alumnoDTO.setSede(sede);
        alumnoDTO.setCarrera(carrera);

        return alumnoDTO;

    }

    @Override
    public Alumno findByCodigoA(Long codigoA) {
        
        return alumnoRepository.findByCodigoA(codigoA).orElseThrow(() ->  new EntityNotFoundException("Alumno no encontrado con el codigoA"+codigoA.toString()));
        
    }
}
