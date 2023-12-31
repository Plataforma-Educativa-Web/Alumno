package pe.cibertec.ProyectoFinal.ApiAlumno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient

public class ApiAlumnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAlumnoApplication.class, args);
	}

}
