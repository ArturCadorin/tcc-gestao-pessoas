package com.gestao_pessoas.tccII.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gestao_pessoas.tccII.repositories.EmpresaRepository;
import com.gestao_pessoas.tccII.services.exceptions.DatabaseException;
import com.gestao_pessoas.tccII.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

import com.gestao_pessoas.tccII.dto.EmpresaDTO;
import com.gestao_pessoas.tccII.entities.Empresa;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository repository;
	private final String entityName = "Empresa";
	
	// Converter entidade para DTO
	public EmpresaDTO convertToDTO(Empresa empresa) {
		EmpresaDTO dto = new EmpresaDTO(empresa);
		return dto;
	}
	
	// Converter DTO para entidade
	public Empresa convertToEntity(EmpresaDTO empresaDTO) {
		Empresa empresa = new Empresa(empresaDTO);
		return empresa;
	}
	
	// Converter a entidade para uma lista de DTO
	public List<EmpresaDTO> convertToDTOList(List<Empresa> empresas) {
	    return empresas.stream()
	        .map(empresa -> new EmpresaDTO(empresa))
	        .collect(Collectors.toList());
	}
	
	// Buscar todas as empresas
	public List<EmpresaDTO> findAll(){
		List<Empresa> empresa = repository.findAll();
		return convertToDTOList(empresa);
	}
	
	// Buscar por ID
	public EmpresaDTO findById(Long id) {
		Empresa empresa = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entityName, id));
		return convertToDTO(empresa);
	}
	
	// Inserir empresa
	public Empresa insert(EmpresaDTO empresaDTO) {
		Empresa empresa = convertToEntity(empresaDTO);
		return repository.save(empresa);
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
