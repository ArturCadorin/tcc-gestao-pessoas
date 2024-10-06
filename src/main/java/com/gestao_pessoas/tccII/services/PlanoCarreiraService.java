package com.gestao_pessoas.tccII.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gestao_pessoas.tccII.entities.PlanoCarreira;
import com.gestao_pessoas.tccII.repositories.PlanoCarreiraRepository;
import com.gestao_pessoas.tccII.services.exceptions.DatabaseException;
import com.gestao_pessoas.tccII.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PlanoCarreiraService {

	@Autowired
	private PlanoCarreiraRepository repository;
	private final String entityName = "Plano_Carreira";
	
	// Buscar todos os plano de carreiras
	public List<PlanoCarreira> findAll(){
		return repository.findAll();
	}
	
	// Buscar por ID
	public PlanoCarreira findById(Long id) {
		Optional<PlanoCarreira> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(entityName, id));
	}
	
	// Inserir plano carreira
	public PlanoCarreira insert(PlanoCarreira obj) {
		return repository.save(obj);
	}
	
	// Deleção plano carreira
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	// Atualizar plano carreira
	public PlanoCarreira update(Long id, PlanoCarreira obj) {
		try {
			PlanoCarreira entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(entityName,id);
		}
	}

	private void updateData(PlanoCarreira entity, PlanoCarreira obj) {
		entity.setNome(obj.getNome());
		entity.setNivel(obj.getNivel());
		entity.setDataFinal(obj.getDataFinal());
		entity.setCargos(obj.getCargos());
	}
}
