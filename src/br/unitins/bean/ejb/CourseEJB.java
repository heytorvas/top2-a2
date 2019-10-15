package br.unitins.bean.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Course;
import br.unitins.model.Syllabus;

@Stateful
public class CourseEJB {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Course course, Integer idSyllabus) {
		course.setSyllabus(em.find(Syllabus.class, idSyllabus));
		em.persist(course);
	}
	
	public void update(Course course) {
		em.merge(course);
	}
	
	public void delete(Course course) {
		course = load(course.getId());
		em.remove(course);
	}
	
	public Course load(Integer id) {
		return em.find(Course.class, id);
	}
	
	public List<Course> findAll(){
		return em.createQuery("select cou from Course cou", Course.class).getResultList();
	}
}
