package br.unitins.model;

import br.unitins.model.Period;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;


@Entity
public class Syllabus implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String label;
	
	@ManyToOne
	@JoinColumn(name = "period_id_fk")
	private Period period;
	
	private static final long serialVersionUID = 1L;

	public Syllabus() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}   
	public Period getPeriod() {
		return this.period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}
   
}
