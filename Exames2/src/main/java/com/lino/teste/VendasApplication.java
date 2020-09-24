package com.lino.teste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VendasApplication {

//	@Bean
//	public CommandLineRunner run(@Autowired PacienteRepository repository) {
//		return args ->{
//			Paciente paciente = Paciente.builder().nome("Felipe").cpf("49366901808").build();
//			repository.save(paciente);
//			
//		};
//	}
//	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);

	}

}
