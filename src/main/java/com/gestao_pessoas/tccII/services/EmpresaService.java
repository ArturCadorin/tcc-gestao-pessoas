package com.gestao_pessoas.tccII.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gestao_pessoas.tccII.repositories.EmpresaRepository;
import com.gestao_pessoas.tccII.services.exceptions.DatabaseException;
import com.gestao_pessoas.tccII.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

import com.gestao_pessoas.tccII.entities.Empresa;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository repository;
	private final String entityName = "Empresa";
	
	// Buscar todas as empresas
	public List<Empresa> findAll(){
		return repository.findAll();
	}
	
	// Buscar por ID
	public Empresa findById(Long id) {
		Optional<Empresa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(entityName, id));
	}
	
	// Inserir empresa
	public Empresa insert(Empresa obj) {
		return repository.save(obj);
	}
	
	// Deleção empresa
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	// Atualizar empresa
	public Empresa update(Long id, Empresa obj) {
		try {
			Empresa entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(entityName,id);
		}
	}

	private void updateData(Empresa entity, Empresa obj) {
		entity.setNome(obj.getNome());
		entity.setSetores(obj.getSetores());
		entity.setCargos(obj.getCargos());
		entity.setColaboradores(obj.getColaboradores());
	}
}
