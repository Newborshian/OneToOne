package org.formation.hibernate.client;

import org.formation.hibernate.entity.Customer;
import org.formation.hibernate.entity.Passport;
import org.formation.hibernate.entity.Professor;
import org.formation.hibernate.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestClientPersit {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();


        try {
            entityTransaction.begin();

            Passport passport = new Passport("YYYYYYYYYY");
            Customer customer = new Customer();
            customer.setName("Jean-neymar");
            customer.setPassport(passport);
            entityManager.persist(passport);
            entityManager.persist(customer);
            entityTransaction.commit();


        } catch (Exception e) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
}
