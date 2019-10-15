package br.unitins.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;


@Entity
@Table(name = "subject")
public class Subject implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String nameSubject;
	
	@Column
	private String menuSubject;
	
	@Column
	private Integer workloadSubject;
	
	private static final long serialVersionUID = 1L;

	public Subject() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNameSubject() {
		return this.nameSubject;
	}

	public void setNameSubject(String nameSubject) {
		this.nameSubject = nameSubject;
	}   
	public String getMenuSubject() {
		return this.menuSubject;
	}

	public void setMenuSubject(String menuSubject) {
		this.menuSubject = menuSubject;
	}   
	public Integer getWorkloadSubject() {
		return this.workloadSubject;
	}

	public void setWorkloadSubject(Integer workloadSubject) {
		this.workloadSubject = workloadSubject;
	}
   
}
