package br.unitins.model;

import br.unitins.model.Subject;
import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

@Entity
public class Period implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private Integer numPeriod;
	
	@ManyToOne
	@JoinColumn(name = "subject_id_fk")
	private Subject subject;
	
	private static final long serialVersionUID = 1L;

	public Period() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Integer getNumPeriod() {
		return this.numPeriod;
	}

	public void setNumPeriod(Integer numPeriod) {
		this.numPeriod = numPeriod;
	}   
	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
   
}
