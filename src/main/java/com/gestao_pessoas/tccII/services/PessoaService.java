package com.gestao_pessoas.tccII.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestao_pessoas.tccII.entities.Pessoa;
import com.gestao_pessoas.tccII.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	// Buscar todas as pessoas
	public List<Pessoa> findAll(){
		return repository.findAll();
	}
}
