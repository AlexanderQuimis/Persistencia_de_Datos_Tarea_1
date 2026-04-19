package repository;

import modelo.CorteCarne;
import util.JPAUtil;

import jakarta.persistence.EntityManager;
import java.util.List;

public class CorteCarneRepository {

    // CREATE
    public void guardar(CorteCarne carne) {
        EntityManager em = JPAUtil.getEntityManager();
        // Inicia una transacción
        em.getTransaction().begin();
        // Guarda el objeto en la BD
        em.persist(carne);
         // Confirma cambios
        em.getTransaction().commit();
        em.close();
    }

    // READ
    public List<CorteCarne> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        List<CorteCarne> lista =
                em.createQuery("SELECT c FROM CorteCarne c", CorteCarne.class)
                  .getResultList();
        em.close();
        return lista;
    }

    // UPDATE
    public void actualizar(CorteCarne carne) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        em.merge(carne);

        em.getTransaction().commit();
        em.close();
    }

    // DELETE
    public void eliminar(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        CorteCarne carne = em.find(CorteCarne.class, id);
        if (carne != null) {
            em.remove(carne);
        }

        em.getTransaction().commit();
        em.close();
    }
}