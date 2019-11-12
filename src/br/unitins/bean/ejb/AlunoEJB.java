package br.unitins.bean.ejb;

import br.unitins.model.Aluno;


import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateful
public class AlunoEJB {
	
    @PersistenceContext
    private EntityManager em;

    public void insert(Aluno aluno) {
        em.persist(aluno);
    }

    public void update(Aluno aluno) {
        em.merge(aluno);
    }

    public void delete(Aluno aluno) {
        Aluno tmpAluno = load(aluno.getIdAluno());
        em.remove(tmpAluno);
    }

    public Aluno load(Integer id) {
        return em.find(Aluno.class, id);
    }

    public List<Aluno> findAll() {
        return em.createQuery("select tp from Aluno tp", Aluno.class).getResultList();
    }
}
