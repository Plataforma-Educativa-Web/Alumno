package pe.cibertec.ProyectoFinal.ApiAlumno.dao;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import pe.cibertec.ProyectoFinal.ApiAlumno.entity.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

    Optional<Alumno> findByNombre(String nombre);
    Optional<Alumno> findByCodigoA(Long codigoA);
}
