package com.alura.literalura;

import com.alura.literalura.Principal.Principal;
import com.alura.literalura.repository.AutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
	private AutoresRepository repository;

	public static void main(String[] args) {

		SpringApplication.run(LiteraluraApplication.class, args);
	}
	@Override
	public void run (String...args)throws Exception{
		Principal principal = new Principal(repository);
		principal.muestraElMenu();
	}
}
