package com.gestao_pessoas.tccII.dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.gestao_pessoas.tccII.entities.Cargo;
import com.gestao_pessoas.tccII.entities.Colaborador;
import com.gestao_pessoas.tccII.entities.Empresa;
import com.gestao_pessoas.tccII.entities.PlanoCarreira;
import com.gestao_pessoas.tccII.entities.Setor;

public class CargoDTO {
	
	private Long id;
	private String nome;
	private String descricao;
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	private Setor setor;
	protected PlanoCarreira nivelProfissional;
	private List<Colaborador> colaboradores;
	private Empresa empresa;
	
	public CargoDTO(Cargo cargo) {
		BeanUtils.copyProperties(cargo, this);
	}
	public CargoDTO() {
		
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}
	public LocalDate getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	public PlanoCarreira getNivelProfissional() {
		return nivelProfissional;
	}
	public void setNivelProfissional(PlanoCarreira nivelProfissional) {
		this.nivelProfissional = nivelProfissional;
	}
	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}
	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}
