package br.unitins.bean.ejb;

import br.unitins.model.Matricula;
import br.unitins.model.Nota;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateful
public class NotaEJB {
	@PersistenceContext
	private EntityManager em;

	public void insert(Nota nota, Integer idMatricula) {
		nota.setMatricula(em.find(Matricula.class, idMatricula));
		em.persist(nota);
	}

	public void update(Nota nota, Integer idMatricula) {
		nota.setMatricula(em.find(Matricula.class, idMatricula));
		em.merge(nota);
	}

	public void delete(Nota nota) {
		Nota tmpNota = load(nota.getIdNota());
		em.remove(tmpNota);
	}

	public Nota load(Integer id) {
		return em.find(Nota.class, id);
	}

	public List<Nota> findAll() {
		return em.createQuery("select tp from Nota tp", Nota.class).getResultList();
	}
}
