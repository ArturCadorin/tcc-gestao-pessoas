package com.gestao_pessoas.tccII.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gestao_pessoas.tccII.dto.PlanoCarreiraDTO;
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
	
	// Converter entidade para DTO
	public PlanoCarreiraDTO convertToDTO(PlanoCarreira planoCarreira) {
		PlanoCarreiraDTO dto = new PlanoCarreiraDTO(planoCarreira);
		return dto;
	}
	
	// Converter DTO para entidade
	public PlanoCarreira convertToEntity(PlanoCarreiraDTO planoCarreiraDTO) {
		PlanoCarreira planoCarreira = new PlanoCarreira(planoCarreiraDTO);
		return planoCarreira;
	}
	
	// Converter a entidade para uma lista de DTO
	public List<PlanoCarreiraDTO> convertToDTOList(List<PlanoCarreira> planoCarreiras) {
	    return planoCarreiras.stream()
	        .map(planoCarreira -> new PlanoCarreiraDTO(planoCarreira))
	        .collect(Collectors.toList());
	}
	
	// Buscar todos os plano de carreiras
	public List<PlanoCarreiraDTO> findAll(){
		List<PlanoCarreira> planoCarreira = repository.findAll();
		return convertToDTOList(planoCarreira);
	}
	
	// Buscar por ID
	public PlanoCarreiraDTO findById(Long id) {
		PlanoCarreira planoCarreira = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entityName, id));
		return convertToDTO(planoCarreira);
	}
	
	// Inserir plano carreira
	public PlanoCarreira insert(PlanoCarreiraDTO planoCarreiraDTO) {
		PlanoCarreira planoCarreira = convertToEntity(planoCarreiraDTO);
		return repository.save(planoCarreira);
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
