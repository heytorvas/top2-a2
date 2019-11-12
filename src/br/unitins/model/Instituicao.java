package br.unitins.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

@Entity
public class Instituicao implements Serializable {

	@Id
	@GeneratedValue
	private Integer idInstituicao;

	@Column
	private String nomeInstituicao;

	private static final long serialVersionUID = 1L;

	public Instituicao() {
		super();
	}

	public Integer getIdInstituicao() {
		return idInstituicao;
	}

	public void setIdInstituicao(Integer idInstituicao) {
		this.idInstituicao = idInstituicao;
	}

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	

}
