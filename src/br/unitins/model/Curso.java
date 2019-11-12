package br.unitins.model;

import br.unitins.model.Instituicao;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

@Entity
public class Curso implements Serializable {

	   
	@Id
	private Integer idCurso;
	private String nomeCurso;
	private Instituicao instituicao;
	private static final long serialVersionUID = 1L;

	public Curso() {
		super();
	}   
	public Integer getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}   
	public String getNomeCurso() {
		return this.nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}   
	public Instituicao getInstituicao() {
		return this.instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
   
}
