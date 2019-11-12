package br.unitins.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;


@Entity
public class Semestre implements Serializable {

	   
	@Id
	private Integer id;
	private String nome;
	private static final long serialVersionUID = 1L;

	public Semestre() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
   
}
