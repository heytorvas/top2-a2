package br.unitins.bean.ejb;

import br.unitins.model.Professor;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateful
public class ProfessorEJB {
	@PersistenceContext
	private EntityManager em;

	public void insert(Professor professor) {
		em.persist(professor);
	}

	public void update(Professor professor) {
		em.merge(professor);
	}

	public void delete(Professor professor) {
		Professor tmpProfessor = load(professor.getIdProfessor());
		em.remove(tmpProfessor);
	}

	public Professor load(Integer id) {
		return em.find(Professor.class, id);
	}

	public List<Professor> findAll() {
		return em.createQuery("select tp from Professor tp", Professor.class).getResultList();
	}
}
