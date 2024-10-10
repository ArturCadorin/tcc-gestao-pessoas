package com.gestao_pessoas.tccII.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gestao_pessoas.tccII.dto.SetorDTO;
import com.gestao_pessoas.tccII.entities.Setor;
import com.gestao_pessoas.tccII.repositories.SetorRepository;
import com.gestao_pessoas.tccII.services.exceptions.DatabaseException;
import com.gestao_pessoas.tccII.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SetorService {

	@Autowired
	private SetorRepository repository;
	private final String entityName = "Setor";
	
	// Converter entidade para DTO
	public SetorDTO convertToDTO(Setor setor) {
		SetorDTO dto = new SetorDTO(setor);
		return dto;
	}
	
	// Converter DTO para entidade
	public Setor convertToEntity(SetorDTO setorDTO) {
		Setor setor = new Setor(setorDTO);
		return setor;
	}
	
	// Converter a entidade para uma lista de DTO
	public List<SetorDTO> convertToDTOList(List<Setor> setores) {
	    return setores.stream()
	        .map(setor -> new SetorDTO(setor))
	        .collect(Collectors.toList());
	}
	
	// Buscar todas as empresas
	public List<SetorDTO> findAll(){
		List<Setor> setor = repository.findAll();
		return convertToDTOList(setor);
	}
	
	// Buscar por ID
	public SetorDTO findById(Long id) {
		Setor setor = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entityName, id));
		return convertToDTO(setor);
	}
	
	// Inserir setor
	public Setor insert(SetorDTO setorDTO) {
		Setor setor = convertToEntity(setorDTO);
		return repository.save(setor);
	}
	
	// Deleção setor
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	// Atualizar setor
	public Setor update(Long id, Setor obj) {
		try {
			Setor entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(entityName,id);
		}
	}

	private void updateData(Setor entity, Setor obj) {
		entity.setNome(obj.getNome());
		entity.setDescricao(obj.getDescricao());
		entity.setDataFinal(obj.getDataFinal());
		entity.setCargos(obj.getCargos());
		entity.setColaboradores(obj.getColaboradores());
	}
}
