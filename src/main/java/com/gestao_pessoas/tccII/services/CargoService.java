package com.gestao_pessoas.tccII.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gestao_pessoas.tccII.entities.Cargo;
import com.gestao_pessoas.tccII.repositories.CargoRepository;
import com.gestao_pessoas.tccII.services.exceptions.DatabaseException;
import com.gestao_pessoas.tccII.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repository;
	private final String entityName = "Cargo";
	
	// Buscar todas as empresas
	public List<Cargo> findAll(){
		return repository.findAll();
	}
	
	// Buscar por ID
	public Cargo findById(Long id) {
		Optional<Cargo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(entityName, id));
	}
	
	// Inserir cargo
	public Cargo insert(Cargo obj) {
		return repository.save(obj);
	}
		
	// Deleção cargo
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
		
	// Atualizar cargo
	public Cargo update(Long id, Cargo obj) {
		try {
			Cargo entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(entityName,id);
		}
	}

	private void updateData(Cargo entity, Cargo obj) {
		entity.setNome(obj.getNome());
		entity.setDescricao(obj.getDescricao());
		entity.setDataFinal(obj.getDataFinal());
		entity.setColaboradores(obj.getColaboradores());
	}
}
