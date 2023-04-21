package es.ufv.pgpi.itnow.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BackApplication {

	public static void main(String[] args) {
		//SpringApplication.run(BackApplication.class, args);

		PGL_BDDTemporal bddTemporal = new PGL_BDDTemporal();
		PGL_productosBDD productosBDD = new PGL_productosBDD();

		bddTemporal.BDD();
	}
}

