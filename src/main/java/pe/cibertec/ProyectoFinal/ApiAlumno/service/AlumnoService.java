package pe.cibertec.ProyectoFinal.ApiAlumno.service;

import java.util.List;
import pe.cibertec.ProyectoFinal.ApiAlumno.entity.Alumno;

public interface AlumnoService {

    public List<Alumno> findAll();

    public Alumno buscarPorId(Long id);

    public Alumno findByNombre(String nombre);

    public Alumno agregarAlumno(Alumno alumno);

    public Alumno actualizarAlumno(Alumno alumno);

    public void eliminarAlumno(Long id);

}
