package com.gestao_pessoas.tccII.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestao_pessoas.tccII.entities.PlanoCarreira;
import com.gestao_pessoas.tccII.repositories.PlanoCarreiraRepository;

@Service
public class PlanoCarreiraService {

	@Autowired
	private PlanoCarreiraRepository repository;
	
	// Buscar todos os plano de carreiras
	public List<PlanoCarreira> findAll(){
		return repository.findAll();
	}
}
