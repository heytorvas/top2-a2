package br.unitins.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

@Entity
public class Disciplina implements Serializable {

	   
	@Id
	private Integer idDisciplina;
	private String codigo;
	private String nome;
	private Integer ch;
	private static final long serialVersionUID = 1L;

	public Disciplina() {
		super();
	}   
	public Integer getIdDisciplina() {
		return this.idDisciplina;
	}

	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}   
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public Integer getCh() {
		return this.ch;
	}

	public void setCh(Integer ch) {
		this.ch = ch;
	}
   
}
