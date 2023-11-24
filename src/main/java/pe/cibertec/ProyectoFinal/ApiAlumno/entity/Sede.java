package pe.cibertec.ProyectoFinal.ApiAlumno.entity;

import lombok.Data;

@Data

public class Sede {

    private Long id;
    private Long codigoS;
    private String distrito;
    private String direccion;
    private String indicaciones;
    private String telefono;
    private String correo;

}
