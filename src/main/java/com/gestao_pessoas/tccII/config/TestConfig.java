package com.gestao_pessoas.tccII.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gestao_pessoas.tccII.entities.Cargo;
import com.gestao_pessoas.tccII.entities.Colaborador;
import com.gestao_pessoas.tccII.entities.Empresa;
import com.gestao_pessoas.tccII.entities.PlanoCarreira;
import com.gestao_pessoas.tccII.entities.Setor;
import com.gestao_pessoas.tccII.enums.NivelPlanoCarreira;
import com.gestao_pessoas.tccII.enums.Sexo;
import com.gestao_pessoas.tccII.repositories.CargoRepository;
import com.gestao_pessoas.tccII.repositories.ColaboradorRepository;
import com.gestao_pessoas.tccII.repositories.EmpresaRepository;
import com.gestao_pessoas.tccII.repositories.PlanoCarreiraRepository;
import com.gestao_pessoas.tccII.repositories.SetorRepository;

// Classe de configuração TESTE, exclusiva para popular banco de dados H2

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private SetorRepository setorRepository;
	@Autowired
	private CargoRepository cargoRepository;
	@Autowired
	private PlanoCarreiraRepository planoCarreiraRepository;
	@Autowired
	private ColaboradorRepository colaboradorRepository;	

	@Override
	public void run(String... args) throws Exception {
		
		//Empresa
		Empresa emp1 = new Empresa(null, "Betha Sistemas", "99.921.233/0001-94", LocalDate.now());
		empresaRepository.save(emp1);
			
		//Setor
		Setor set1 = new Setor(null, "Serviços", "Setor de sucesso ao cliente", LocalDate.now(), emp1);
		Setor set2 = new Setor(null, "Desenvolvimento", "Setor de programação e produto", LocalDate.now(), emp1);
		List<Setor> setores = new ArrayList<>();
		setores.add(set1);
		setores.add(set2);
		emp1.setSetores(setores);
		setorRepository.saveAll(setores);
		
		//Plano de carreira
		PlanoCarreira plano1 = new PlanoCarreira(null, "Plano geral", NivelPlanoCarreira.JUNIOR, 25000.00, LocalDate.now());
		planoCarreiraRepository.save(plano1);
		
		//Cargo
		Cargo cargo1 = new Cargo(null, "Analista I", "Analista programadora blabla", LocalDate.now(), emp1, set1, plano1);
		Cargo cargo2 = new Cargo(null, "Desenvolvedor I", "Programador pleno blabla", LocalDate.now(), emp1, set2, plano1);
		List<Cargo> cargos = new ArrayList<>();
		plano1.setCargos(cargos);
		cargos.add(cargo1);
		cargos.add(cargo2);
		cargoRepository.saveAll(cargos);
		
		//Colaborador
		Colaborador colaborador = new Colaborador(
				null, 
				"Artur de Jesus Cadorin", 
				LocalDate.now(), 
				"090.159.129-71", 
				"5.961-451", 
				Sexo.MASCULINO,
				emp1, 
				12345, 
				LocalDate.now(),
				set1, 
				cargo1);	
		colaboradorRepository.save(colaborador);
		
		
	}
}
