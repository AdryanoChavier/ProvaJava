package orm.actions;

import orm.modelo.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlunoCrud {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public AlunoCrud() {
    	  entityManagerFactory = Persistence.createEntityManagerFactory("alunos");
          entityManager = entityManagerFactory.createEntityManager();
		
    }
    public void inserirAluno(Aluno alunos) {
        entityManager.getTransaction().begin();
        entityManager.persist(alunos);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Aluno> listarAlunos() {
        String jpql = "SELECT a FROM Aluno a";
        TypedQuery<Aluno> query = entityManager.createQuery(jpql, Aluno.class);
        List<Aluno> Aluno = query.getResultList();
        entityManager.close();
        return Aluno;
    }

    public List<Aluno> listarAlunosPorInicial(String inicial) {
        TypedQuery<Aluno> query = entityManager.createQuery(
                "SELECT a FROM Aluno a WHERE LOWER(SUBSTRING(a.nome, 1, 1)) = :inicial", Aluno.class);
        query.setParameter("inicial", inicial.toLowerCase());
        return query.getResultList();
    }

    public Aluno buscarAluno(Long id) {
        return entityManager.find(Aluno.class, id);
    }

    public void atualizarAluno(Aluno alunos) {
        entityManager.getTransaction().begin();
        entityManager.merge(alunos);
        entityManager.getTransaction().commit();
    }

    public void removerAluno(Long id) {
        entityManager.getTransaction().begin();
        Aluno aluno = entityManager.find(Aluno.class, id);
        if (aluno != null) {
            entityManager.remove(aluno);
        }
        entityManager.getTransaction().commit();
    }

    public void fecharConexao() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
