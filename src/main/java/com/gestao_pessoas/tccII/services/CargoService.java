package com.gestao_pessoas.tccII.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestao_pessoas.tccII.entities.Cargo;
import com.gestao_pessoas.tccII.repositories.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repository;
	
	// Buscar todas as empresas
	public List<Cargo> findAll(){
		return repository.findAll();
	}
}
