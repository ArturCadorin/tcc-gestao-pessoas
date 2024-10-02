package com.gestao_pessoas.tccII.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gestao_pessoas.tccII.entities.Empresa;
import com.gestao_pessoas.tccII.repositories.EmpresaRepository;

// Classe de configuração TESTE, exclusiva para popular banco de dados H2

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Empresa emp1 = new Empresa(null, "Betha Sistemas", "99.921.233/0001-94", LocalDate.now());
		Empresa emp2 = new Empresa(null, "Thomson Reuters", "92.615.448/0001-38", LocalDate.now());
		
		// Irá instanciar banco de dados 
		empresaRepository.saveAll(Arrays.asList(emp1, emp2));
	}
	
	
}
