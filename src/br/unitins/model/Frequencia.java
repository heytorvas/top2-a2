package br.unitins.model;

import br.unitins.model.Matricula;
import java.io.Serializable;
import java.lang.Integer;
import java.sql.Date;
import javax.persistence.*;

@Entity
public class Frequencia implements Serializable {

	   
	@Id
	private Integer idFrequencia;
	private Date data;
	private Date horaInicio;
	private Date horaFim;
	private Matricula matricula;
	private static final long serialVersionUID = 1L;

	public Frequencia() {
		super();
	}   
	public Integer getIdFrequencia() {
		return this.idFrequencia;
	}

	public void setIdFrequencia(Integer idFrequencia) {
		this.idFrequencia = idFrequencia;
	}   
	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}   
	public Date getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}   
	public Date getHoraFim() {
		return this.horaFim;
	}

	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}   
	public Matricula getMatricula() {
		return this.matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
   
}
