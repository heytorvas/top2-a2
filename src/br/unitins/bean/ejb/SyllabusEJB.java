package br.unitins.bean.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Period;
import br.unitins.model.Syllabus;

@Stateful
public class SyllabusEJB {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Syllabus syllabus, Integer idPeriod) {
		syllabus.setPeriod(em.find(Period.class, idPeriod));
		em.persist(syllabus);
	}
	
	public void update(Syllabus syllabus) {
		em.merge(syllabus);
	}
	
	public void delete(Syllabus syllabus) {
		syllabus = load(syllabus.getId());
		em.remove(syllabus);
	}
	
	public Syllabus load(Integer id) {
		return em.find(Syllabus.class, id);
	}
	
	public List<Syllabus> findAll(){
		return em.createQuery("select s from Syllabus s", Syllabus.class).getResultList();
	}
}
