package pe.cibertec.ProyectoFinal.ApiAlumno.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Alumno {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String nombre;
    private String apellido;
    private String sexo;
    private String email;
    private String edad;
    private String celular;
    
}
