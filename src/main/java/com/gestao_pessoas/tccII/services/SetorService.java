package com.gestao_pessoas.tccII.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestao_pessoas.tccII.entities.Setor;
import com.gestao_pessoas.tccII.repositories.SetorRepository;

@Service
public class SetorService {

	@Autowired
	private SetorRepository repository;
	
	// Buscar todas as empresas
	public List<Setor> findAll(){
		return repository.findAll();
	}
}
