package com.gestao_pessoas.tccII.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.gestao_pessoas.tccII.enums.Sexo;
import com.gestao_pessoas.tccII.enums.SituacaoColaborador;

import jakarta.persistence.*;

@Entity
public class Colaborador extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	private int matricula;
	
	private LocalDate dataAdmissao;
	private LocalDate dataFinal;
	
	@Enumerated(EnumType.STRING)
	private SituacaoColaborador situacaoColaborador;
	
	@ManyToOne
	@JoinColumn(name = "setor_id")
	private Setor setor;
	
	@ManyToOne
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;
	
	private int diasAfastado;
	private int diasFerias;
	
	//CONSTRUCTOR
	public Colaborador(Long id, String nome, LocalDate nascimento, String cpf, String rg, Sexo sexo, Empresa empresa, int matricula, LocalDate dataAdmissao, Setor setor, Cargo cargo) {
		super(id, nome, nascimento, cpf, rg, sexo, empresa);
		this.matricula = matricula;
		this.dataAdmissao = dataAdmissao;
		this.setor = setor;
		this.cargo = cargo;
	}
	
	//GETTERS e SETTERS
	public Long getId() {
		return id;
	}
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
	public LocalDate getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	public SituacaoColaborador getSituacaoColaborador() {
		return situacaoColaborador;
	}
	public void setSituacaoColaborador(SituacaoColaborador situacaoColaborador) {
		this.situacaoColaborador = situacaoColaborador;
	}
	
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	public int getDiasAfastado() {
		return diasAfastado;
	}
	public void setDiasAfastado(int diasAfastado) {
		this.diasAfastado = diasAfastado;
	}
	
	public int getDiasFerias() {
		return diasFerias;
	}
	public void setDiasFerias(int diasFerias) {
		this.diasFerias = diasFerias;
	}
	
	// Gera um afastamento para o colaborador.
	// Deve receber por paramêtro a quantidade de dias de afastamento
	public void gerarAfastamento(int diasAfastado) {
		this.situacaoColaborador = SituacaoColaborador.AFASTADO;
		this.diasAfastado += diasAfastado;
	}
	
	// Gera uma férias para o colaborador
	// Deve receber por paramêtro a quantidade de dias de férias
	public void gerarFerias(int diasFerias) {
		this.situacaoColaborador = SituacaoColaborador.FERIAS;
		this.diasFerias += diasFerias;
	}
	
	// Gera uma demissão para o colaborador
	// Deve receber por paramêtro a data de demissão
	public void gerarDemissao(LocalDate dataDemissao) {
		this.situacaoColaborador = SituacaoColaborador.DEMITIDO;
		this.dataFinal = dataDemissao;
	}
	
	// Aumenta o salário do colaborador
	// Deve receber por paramêtro a porcentagem de bonificação
	public void bonificacaoSalarial(double bonificacao) {
		double salario = this.cargo.nivelProfissional.getRemuneracao();
		this.cargo.nivelProfissional.alteracaoSalarial(salario, bonificacao);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id, matricula);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colaborador other = (Colaborador) obj;
		return id == other.id && matricula == other.matricula;
	}
	
}
