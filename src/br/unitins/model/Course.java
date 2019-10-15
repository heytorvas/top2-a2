package br.unitins.model;

import br.unitins.model.Syllabus;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;


@Entity
public class Course implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String nameCourse;
	
	@Column
	private String label;
	
	@Column
	private Integer workloadCourse;
	
	@ManyToOne
	@JoinColumn(name = "syllabus_id_fk")
	private Syllabus syllabus;
	
	private static final long serialVersionUID = 1L;

	public Course() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNameCourse() {
		return this.nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}   
	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}   
	public Integer getWorkloadCourse() {
		return this.workloadCourse;
	}

	public void setWorkloadCourse(Integer workloadCourse) {
		this.workloadCourse = workloadCourse;
	}   
	public Syllabus getSyllabus() {
		return this.syllabus;
	}

	public void setSyllabus(Syllabus syllabus) {
		this.syllabus = syllabus;
	}
   
}
