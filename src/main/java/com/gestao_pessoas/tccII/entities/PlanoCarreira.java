package com.gestao_pessoas.tccII.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gestao_pessoas.tccII.enums.NivelPlanoCarreira;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_plano_carreira")
public class PlanoCarreira implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private NivelPlanoCarreira nivel;
	
	private double remuneracao;
	private LocalDate dataInicial;
	private LocalDate dataFinal;	
	
	@OneToMany(mappedBy = "nivelProfissional")
	@JsonBackReference
	private List<Cargo> cargos;
	
	//CONSTRUCTOR
	public PlanoCarreira(Long id, String nome, NivelPlanoCarreira nivel, double remuneracao, LocalDate dataInicial) {
		this.id = id;
		this.nome = nome;
		this.nivel = nivel;
		this.remuneracao = remuneracao;
		this.dataInicial = dataInicial;
	}
	public PlanoCarreira() {
		super();
	}
	
	//GETTERS e SETTERS
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
	
	// Método para alteração salarial baseado em porcentagem
	public void alteracaoSalarial(double remuneracao, double pctAumento) {
		double aumento = remuneracao * pctAumento / 100;
		double salarioAtual = this.remuneracao;
		this.remuneracao = aumento + salarioAtual;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanoCarreira other = (PlanoCarreira) obj;
		return id == other.id && Objects.equals(nome, other.nome);
	}
	
}
