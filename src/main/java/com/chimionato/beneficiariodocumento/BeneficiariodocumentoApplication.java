package com.chimionato.beneficiariodocumento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class BeneficiariodocumentoApplication {

	@GetMapping
	public String getHomeTeste() {
		return "API Home está funcionando";
	}

	public static void main(String[] args) {
		SpringApplication.run(BeneficiariodocumentoApplication.class, args);
	}

}
