package com.gestao_pessoas.tccII.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestao_pessoas.tccII.entities.Colaborador;
import com.gestao_pessoas.tccII.repositories.ColaboradorRepository;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repository;
	
	// Buscar todas os colaboradores
	public List<Colaborador> findAll(){
		return repository.findAll();
	}
	
	// Buscar por ID
	public Colaborador findById(Long id) {
		Optional<Colaborador> obj = repository.findById(id);
		return obj.get();
	}
}
