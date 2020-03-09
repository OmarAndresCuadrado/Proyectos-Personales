package inteligencia.artificial.co;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins ="*")
public class InteligenciaArtificialApplication {

	public static void main(String[] args) {
		SpringApplication.run(InteligenciaArtificialApplication.class, args);
	}

}
