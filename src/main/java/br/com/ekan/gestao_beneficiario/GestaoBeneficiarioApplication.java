package br.com.ekan.gestao_beneficiario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/home")
public class GestaoBeneficiarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoBeneficiarioApplication.class, args);
	}
	
	@GetMapping
	public String getHome() {
		return "Gestao Beneficiario - API Home";
	}

}
