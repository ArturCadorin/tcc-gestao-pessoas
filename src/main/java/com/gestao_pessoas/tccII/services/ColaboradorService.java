package com.gestao_pessoas.tccII.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gestao_pessoas.tccII.dto.ColaboradorDTO;
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
	
	// Converter entidade para DTO
	public ColaboradorDTO convertToDTO(Colaborador colaborador) {
		ColaboradorDTO dto = new ColaboradorDTO(colaborador);
		return dto;
	}
	
	// Converter DTO para entidade
	public Colaborador convertToEntity(ColaboradorDTO colaboradorDTO) {
	    Colaborador colaborador = new Colaborador(colaboradorDTO);
	    return colaborador;
	}
	
	// Converter a entidade para uma lista de DTO
	public List<ColaboradorDTO> convertToDTOList(List<Colaborador> colaboradores) {
	    return colaboradores.stream()
	        .map(colaborador -> new ColaboradorDTO(colaborador))
	        .collect(Collectors.toList());
	}
	
	// Buscar todas os colaboradores
	public List<ColaboradorDTO> findAll(){
		List<Colaborador> colaborador = repository.findAll();
		return convertToDTOList(colaborador);
	}
	
	// Buscar por ID
	public ColaboradorDTO findById(Long id) {
		Colaborador colaborador = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entityName, id));
		return convertToDTO(colaborador);
	}

	// Inserir cargo
	public Colaborador insert(ColaboradorDTO colaboradorDTO) {
		Colaborador colaborador = convertToEntity(colaboradorDTO);
		return repository.save(colaborador);
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


