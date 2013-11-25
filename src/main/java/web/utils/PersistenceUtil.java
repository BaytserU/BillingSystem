/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
     private static PersistenceUtil instance;

    public static PersistenceUtil getInstance() {
        if (instance == null) {
            instance = new PersistenceUtil();
        }
        return instance;
    }
    
    private EntityManagerFactory emf;

    private PersistenceUtil() {
        emf = Persistence.createEntityManagerFactory("DataPU");
    }
    
    public EntityManager getManager() {
        return emf.createEntityManager();
    }
    
    public void closeFactory() {
        emf.close();
    }
}
