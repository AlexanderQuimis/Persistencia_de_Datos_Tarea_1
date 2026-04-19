package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory emf =
            // Crea la conexión usando persistence.xml
       Persistence.createEntityManagerFactory("com.mycompany_Persistencia_Unidad1_Alexander_Paltas_jar_1.0-SNAPSHOTPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}