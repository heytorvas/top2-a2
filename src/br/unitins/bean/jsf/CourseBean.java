package br.unitins.bean.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.application.Util;
import br.unitins.bean.ejb.CourseEJB;
import br.unitins.bean.ejb.SyllabusEJB;
import br.unitins.model.Course;
import br.unitins.model.Syllabus;

@Named
@RequestScoped
public class CourseBean {
	@EJB
	private CourseEJB courseEJB;
	
	@EJB
	private SyllabusEJB syllabusEJB;
	
	private Course course;
	
	private Integer idSearch;
	
	private Integer idSyllabus;
	
	private List<Course> courses;
	
	private List<Syllabus> syllabus;

	@PostConstruct
	public void init() {
		setSyllabus(syllabusEJB.findAll());
		courses = courseEJB.findAll();
	}
	
	public String insert() {
		courseEJB.insert(course, idSyllabus);
		clean();
		Util.redirect("course.xhtml");
		return null;
	}
	
	public String update() {
		course.setId(getIdSearch());
		courseEJB.update(course);
		clean();
		Util.redirect("course.xhtml");
		return null;
	}
	
	public String delete() {
		courseEJB.delete(courseEJB.load(getIdSearch()));
		clean();
		Util.redirect("course.xhtml");
		return null;
	}
	
	public String clean() {
		course = new Course();
		return null;
	}
	
	public String searchId() {
		course = courseEJB.load(getIdSearch());
		return null;
	}
	
	public Course getCourse() {
		if (course == null) {
			course = new Course();
		}
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Integer getIdSearch() {
		return idSearch;
	}

	public void setIdSearch(Integer idSearch) {
		this.idSearch = idSearch;
	}

	public Integer getIdSyllabus() {
		return idSyllabus;
	}

	public void setIdSyllabus(Integer idSyllabus) {
		this.idSyllabus = idSyllabus;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Syllabus> getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(List<Syllabus> syllabus) {
		this.syllabus = syllabus;
	}
	
	
}
