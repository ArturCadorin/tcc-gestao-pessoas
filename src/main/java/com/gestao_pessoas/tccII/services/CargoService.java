package com.gestao_pessoas.tccII.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestao_pessoas.tccII.entities.Cargo;
import com.gestao_pessoas.tccII.repositories.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repository;
	
	// Buscar todas as empresas
	public List<Cargo> findAll(){
		return repository.findAll();
	}
	
	// Buscar por ID
	public Cargo findById(Long id) {
		Optional<Cargo> obj = repository.findById(id);
		return obj.get();
	}
	
	// Inserir cargo
	public Cargo insert(Cargo obj) {
		return repository.save(obj);
	}
		
	// Deleção cargo
	public void delete(Long id) {
		repository.deleteById(id);
	}
		
	// Atualizar cargo
	public Cargo update(Long id, Cargo obj) {
		Cargo entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Cargo entity, Cargo obj) {
		entity.setNome(obj.getNome());
		entity.setDescricao(obj.getDescricao());
		entity.setDataFinal(obj.getDataFinal());
		entity.setColaboradores(obj.getColaboradores());
	}
}
