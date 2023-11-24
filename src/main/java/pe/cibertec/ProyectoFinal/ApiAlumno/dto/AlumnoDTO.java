package pe.cibertec.ProyectoFinal.ApiAlumno.dto;

import lombok.Data;
import pe.cibertec.ProyectoFinal.ApiAlumno.entity.Carrera;
import pe.cibertec.ProyectoFinal.ApiAlumno.entity.Sede;

@Data

public class AlumnoDTO {

    private Long id;
    private Long codigoA;
    private String nombre;
    private String apellido;
    private Long dni;
    private String sexo;
    private String email;
    private String edad;
    private String celular;
    private Sede sede;
    private Carrera carrera;

}
