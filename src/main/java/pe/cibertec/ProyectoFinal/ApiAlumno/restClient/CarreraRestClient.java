package pe.cibertec.ProyectoFinal.ApiAlumno.restClient;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.cibertec.ProyectoFinal.ApiAlumno.entity.Carrera;

@FeignClient (value = "carrera-service", url ="http://localhost:8082/")

public interface CarreraRestClient {
    
    @GetMapping("api/v1/carrera/findByCodigoC/{codigoC}")
    
    Carrera findByCodigoC (@PathVariable Long codigoC);
    
    @GetMapping("api/v1/carrera/findAll")
    
    List<Carrera> findAllCarrera();
    
}
