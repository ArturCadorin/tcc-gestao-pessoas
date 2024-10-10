package com.gestao_pessoas.tccII.dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.gestao_pessoas.tccII.entities.Cargo;
import com.gestao_pessoas.tccII.entities.Colaborador;
import com.gestao_pessoas.tccII.entities.Empresa;
import com.gestao_pessoas.tccII.entities.Setor;

public class SetorDTO {

	private Long id;
	private String nome;	
	private String descricao;
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	private List<Cargo> cargos;
	private List<Colaborador> colaboradores;
	private Empresa empresa;
	
	public SetorDTO(Setor setor) {
		BeanUtils.copyProperties(setor, this);
	}
	public SetorDTO() {
		
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
	public List<Cargo> getCargos() {
		return cargos;
	}
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
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
