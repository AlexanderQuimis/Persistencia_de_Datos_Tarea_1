package repository;

import modelo.CorteCarne;
import util.JPAUtil;
import modelo.Proveedor;
import jakarta.persistence.EntityManager;
import java.util.List;

public class CorteCarneRepository {

    // CREATE
    public void guardar(CorteCarne carne, Proveedor p) {

        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        em.persist(p);              // 👈 primero proveedor
        carne.setProveedor(p);      // relación

        em.persist(carne);          // luego corte

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
    //Consulta Where - ejemplo 1
    public List<CorteCarne> listarCaros() {
    EntityManager em = JPAUtil.getEntityManager();

    List<CorteCarne> lista = em.createQuery(
        "SELECT c FROM CorteCarne c WHERE c.precio > 20",
        CorteCarne.class
    ).getResultList();

    em.close();
    return lista;
}
    // Ejemplo 2 - Inner Join
    public List<CorteCarne> porProveedor(String nombre) {
    EntityManager em = JPAUtil.getEntityManager();

    List<CorteCarne> lista = em.createQuery(
        "SELECT c FROM CorteCarne c WHERE c.proveedor.nombre = :nombre",
        CorteCarne.class
    )
    .setParameter("nombre", nombre)
    .getResultList();

    em.close();
    return lista;
}
    //Ejemplo 3. Left Join
    public List<Object[]> contarPorProveedor() {
    EntityManager em = JPAUtil.getEntityManager();

    List<Object[]> lista = em.createQuery(
        "SELECT c.proveedor.nombre, COUNT(c) " +
        "FROM CorteCarne c GROUP BY c.proveedor.nombre"
    ).getResultList();

    em.close();
    return lista;
}
}