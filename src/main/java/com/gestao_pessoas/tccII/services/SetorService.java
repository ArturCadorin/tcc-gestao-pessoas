package com.gestao_pessoas.tccII.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestao_pessoas.tccII.entities.Setor;
import com.gestao_pessoas.tccII.repositories.SetorRepository;

@Service
public class SetorService {

	@Autowired
	private SetorRepository repository;
	
	// Buscar todas as empresas
	public List<Setor> findAll(){
		return repository.findAll();
	}
	
	// Buscar por ID
	public Setor findById(Long id) {
		Optional<Setor> obj = repository.findById(id);
		return obj.get();
	}
	
	// Inserir setor
	public Setor insert(Setor obj) {
		return repository.save(obj);
	}
	
	// Deleção setor
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	// Atualizar setor
	public Setor update(Long id, Setor obj) {
		Setor entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Setor entity, Setor obj) {
		entity.setNome(obj.getNome());
		entity.setDescricao(obj.getDescricao());
		entity.setDataFinal(obj.getDataFinal());
		entity.setCargos(obj.getCargos());
		entity.setColaboradores(obj.getColaboradores());
	}
}
