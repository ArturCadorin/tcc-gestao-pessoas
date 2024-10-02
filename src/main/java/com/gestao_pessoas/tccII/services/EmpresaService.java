package com.gestao_pessoas.tccII.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestao_pessoas.tccII.repositories.EmpresaRepository;
import com.gestao_pessoas.tccII.entities.Empresa;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository repository;
	
	// Buscar todas as empresas
	public List<Empresa> findAll(){
		return repository.findAll();
	}
}
