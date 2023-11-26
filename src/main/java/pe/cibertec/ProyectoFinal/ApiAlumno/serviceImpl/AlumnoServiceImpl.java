package pe.cibertec.ProyectoFinal.ApiAlumno.serviceImpl;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j

public class AlumnoServiceImpl implements AlumnoService {

    @Autowired

    private AlumnoRepository alumnoRepository;

    @Autowired

    private SedeRestClient sedeRestClient;

    @Autowired

    private CarreraRestClient carreraRestClient;

    @Override
    public List<Alumno> findAll() {
        log.info("Obteniendo todos los alumnos");

        return (List<Alumno>) alumnoRepository.findAll();

    }

    public List<Sede> findAllSede() {
        log.info("Obteniendo todas las sedes");

        return (List<Sede>) sedeRestClient.findAllSede();

    }

    public List<Carrera> findAllCarrera() {
        log.info("Obteniendo todas las carreras");

        return (List<Carrera>) carreraRestClient.findAllCarrera();

    }

    @Override
    public Alumno findByNombre(String nombre) {
        log.info("Buscando alumno por nombre: {}", nombre);

        return alumnoRepository.findByNombre(nombre).orElseThrow(() -> new EntityNotFoundException("Alumno no encontrado con el nombre " + nombre.toString()));

    }

    @Override
    public Alumno buscarPorId(Long id) {
        log.info("Buscando alumno por ID: {}", id);

        return alumnoRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Alumno no encontrado con el id " + id.toString()));

    }

    @Override
    public Alumno agregarAlumno(Alumno alumno) {
        log.info("Agregando nuevo alumno");

        return alumnoRepository.save(alumno);

    }

    @Override
    public Alumno actualizarAlumno(Alumno alumno) {
        log.info("Actualizando alumno con ID: {}", alumno.getId());

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
        log.info("Eliminando alumno con ID: {}", id);

        var AlumnoF = alumnoRepository.findById(id).get();

        alumnoRepository.delete(AlumnoF);

    }

    @Override
    public AlumnoDTO findById(Long id) {
        log.info("Buscando alumno por ID: {}", id);

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
        log.info("Buscando alumno por códigoA: {}", codigoA);

        return alumnoRepository.findByCodigoA(codigoA).orElseThrow(() -> new EntityNotFoundException("Alumno no encontrado con el codigoA" + codigoA.toString()));

    }
}
