package com.gestao_pessoas.tccII.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gestao_pessoas.tccII.entities.Colaborador;
import com.gestao_pessoas.tccII.repositories.ColaboradorRepository;
import com.gestao_pessoas.tccII.services.exceptions.DatabaseException;
import com.gestao_pessoas.tccII.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repository;
	private final String entityName = "Colaborador";
	
	// Buscar todas os colaboradores
	public List<Colaborador> findAll(){
		return repository.findAll();
	}
	
	// Buscar por ID
	public Colaborador findById(Long id) {
		Optional<Colaborador> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(entityName, id));
	}

	// Inserir cargo
	public Colaborador insert(Colaborador obj) {
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
	public Colaborador update(Long id, Colaborador obj) {
		try {
			Colaborador entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(entityName,id);
		}
	}
	
	private void updateData(Colaborador entity, Colaborador obj) {
		entity.setNome(obj.getNome());
		entity.setDataFinal(obj.getDataFinal());
		entity.setSituacaoColaborador(obj.getSituacaoColaborador());
		entity.setSetor(obj.getSetor());
		entity.setCargo(obj.getCargo());
		entity.setDiasAfastado(obj.getDiasAfastado());
		entity.setDiasFerias(obj.getDiasFerias());
	}
}


