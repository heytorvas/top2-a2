package br.unitins.bean.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Instituicao;

@Stateful
public class InstituicaoEJB {

	@PersistenceContext
	private EntityManager em;

	public void insert(Instituicao instituicao) {
		em.persist(instituicao);
	}

	public void update(Instituicao instituicao) {
		em.merge(instituicao);
	}

	public void delete(Instituicao instituicao) {
		Instituicao tmpFaculdade = load(instituicao.getIdInstituicao());
		em.remove(tmpFaculdade);
	}

	public Instituicao load(Integer id) {
		return em.find(Instituicao.class, id);
	}

	public List<Instituicao> findAll() {
		return em.createQuery("select tp from Faculdade tp", Instituicao.class).getResultList();
	}
}
