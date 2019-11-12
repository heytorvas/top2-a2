package br.unitins.model;

import br.unitins.model.Matricula;
import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import javax.persistence.*;

@Entity
public class Nota implements Serializable {

	   
	@Id
	private Integer idNota;
	private Double nota1;
	private Double nota2;
	private Double exame;
	private Matricula matricula;
	private static final long serialVersionUID = 1L;

	public Nota() {
		super();
	}   
	public Integer getIdNota() {
		return this.idNota;
	}

	public void setIdNota(Integer idNota) {
		this.idNota = idNota;
	}   
	public Double getNota1() {
		return this.nota1;
	}

	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}   
	public Double getNota2() {
		return this.nota2;
	}

	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}   
	public Double getExame() {
		return this.exame;
	}

	public void setExame(Double exame) {
		this.exame = exame;
	}   
	public Matricula getMatricula() {
		return this.matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
   
}
