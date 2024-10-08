package com.gestao_pessoas.tccII.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gestao_pessoas.tccII.dto.CargoDTO;
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
	
	// Converter a entidade para DTO
	public CargoDTO convertToDTO(Cargo cargo) {
		CargoDTO dto = new CargoDTO(cargo);
		return dto;
	}
	
	// Converter DTO para entidade
	public Cargo convertToEntity(CargoDTO cargoDTO) {
	    Cargo cargo = new Cargo(cargoDTO);
	    return cargo;
	}
	
	// Converter a entidade para uma lista de DTO
	public List<CargoDTO> convertToDTOList(List<Cargo> cargos) {
	    return cargos.stream()
	        .map(cargo -> new CargoDTO(cargo))
	        .collect(Collectors.toList());
	}
	
	// Buscar todas as empresas
	public List<CargoDTO> findAll(){
		List<Cargo> cargos = repository.findAll();
	    return convertToDTOList(cargos);
	}
	
	// Buscar por ID
	public CargoDTO findById(Long id) {
		Cargo cargo = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entityName, id));;
		return convertToDTO(cargo);
	}
	
	// Inserir cargo
	public Cargo insert(CargoDTO cargoDTO) {
		Cargo cargo = convertToEntity(cargoDTO);
		return repository.save(cargo);
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
