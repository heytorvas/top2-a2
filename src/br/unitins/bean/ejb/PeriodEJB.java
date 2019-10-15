package br.unitins.bean.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Period;
import br.unitins.model.Subject;

@Stateful
public class PeriodEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Period period, Integer idSubject) {
		period.setSubject(em.find(Subject.class, idSubject));
		em.persist(period);
	}
	
	public void update(Period period) {
		em.merge(period);
	}
	
	public void delete(Period period) {
		period = load(period.getId());
		em.remove(period);
	}
	
	public Period load(Integer id) {
		return em.find(Period.class, id);
	}
	
	public List<Period> findAll(){
		return em.createQuery("select p from Period p", Period.class).getResultList();
	}
}
