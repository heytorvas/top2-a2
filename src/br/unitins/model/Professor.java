package br.unitins.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

@Entity
public class Professor implements Serializable {

	@Id
	private Integer idProfessor;
	private String nomeProfesssor;
	private String email;
	private static final long serialVersionUID = 1L;

	public Professor() {
		super();
	}

	public Integer getIdProfessor() {
		return this.idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getNomeProfesssor() {
		return this.nomeProfesssor;
	}

	public void setNomeProfesssor(String nomeProfesssor) {
		this.nomeProfesssor = nomeProfesssor;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
