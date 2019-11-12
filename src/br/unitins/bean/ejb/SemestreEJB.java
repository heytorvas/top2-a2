package br.unitins.bean.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Semestre;

@Stateful
public class SemestreEJB {
	@PersistenceContext
	private EntityManager em;

	public void insert(Semestre semestre) {
		em.persist(semestre);
	}

	public void update(Semestre semestre) {
		em.merge(semestre);
	}

	public void delete(Semestre semestre) {
		Semestre tmpSemestre = load(semestre.getId());
		em.remove(tmpSemestre);
	}

	public Semestre load(Integer id) {
		return em.find(Semestre.class, id);
	}

	public List<Semestre> findAll() {
		return em.createQuery("select tp from Semestre tp", Semestre.class).getResultList();
	}
}
