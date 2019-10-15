package br.unitins.bean.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Subject;

@Stateful
public class SubjectEJB {
	@PersistenceContext
	private EntityManager em;

	public void insert(Subject subject) {
		em.persist(subject);
	}

	public void update(Subject subject) {
		em.merge(subject);
	}

	public void delete(Subject subject) {
		subject = load(subject.getId());
	}
	
	public Subject load(Integer id) {
		return em.find(Subject.class, id);
	}
	
	public List<Subject> findAll(){
		return em.createQuery("select s from Subject s", Subject.class).getResultList();
	}
}
