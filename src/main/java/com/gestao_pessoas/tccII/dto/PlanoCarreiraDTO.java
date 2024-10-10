package com.gestao_pessoas.tccII.dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.gestao_pessoas.tccII.entities.Cargo;
import com.gestao_pessoas.tccII.entities.PlanoCarreira;
import com.gestao_pessoas.tccII.enums.NivelPlanoCarreira;

public class PlanoCarreiraDTO {

	private Long id;
	private String nome;
	private NivelPlanoCarreira nivel;
	private double remuneracao;
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	private List<Cargo> cargos;
	
	public PlanoCarreiraDTO(PlanoCarreira planoCarreira) {
		BeanUtils.copyProperties(planoCarreira, this);
	}
	public PlanoCarreiraDTO() {
		
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
	public NivelPlanoCarreira getNivel() {
		return nivel;
	}
	public void setNivel(NivelPlanoCarreira nivel) {
		this.nivel = nivel;
	}
	public double getRemuneracao() {
		return remuneracao;
	}
	public void setRemuneracao(double remuneracao) {
		this.remuneracao = remuneracao;
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
	
}
