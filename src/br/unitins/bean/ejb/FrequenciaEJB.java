package br.unitins.bean.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Frequencia;
import br.unitins.model.Matricula;

@Stateful
public class FrequenciaEJB {

	@PersistenceContext
	private EntityManager em;

	public void insert(Frequencia frequencia, Integer idMatricula) {
		frequencia.setMatricula(em.find(Matricula.class, idMatricula));
		em.persist(frequencia);
	}

	public void update(Frequencia frequencia, Integer idMatricula) {
		frequencia.setMatricula(em.find(Matricula.class, idMatricula));
		em.merge(frequencia);
	}

	public void delete(Frequencia frequencia) {
		frequencia = load(frequencia.getIdFrequencia());
		em.remove(frequencia);
	}

	public Frequencia load(Integer id) {
		return em.find(Frequencia.class, id);
	}

	public List<Frequencia> findAll() {
		return em.createQuery("select m from Frequencia m", Frequencia.class).getResultList();
	}
}
