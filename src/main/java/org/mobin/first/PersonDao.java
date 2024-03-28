package org.mobin.first;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonDao {
    @PersistenceContext
    EntityManager entityManager;


    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;


    @Autowired
    Person person;

    public void persist() {
        entityManager = entityManagerFactory.createEntityManager();
        person.setActive(true);
        person.setEmail("mobin.alizadeh2019@gmail.com");
        person.setfName("Mobin");
        person.setlName("Alizadeh");
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(person);
            entityManager.getTransaction().commit();

        }
        catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }

    }
}