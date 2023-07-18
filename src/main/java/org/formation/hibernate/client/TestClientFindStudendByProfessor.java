package org.formation.hibernate.client;

import org.formation.hibernate.entity.Professor;
import org.formation.hibernate.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Set;

public class TestClientFindStudendByProfessor {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Professor professor = null;
        try {
            entityTransaction.begin();
            professor = entityManager.find(Professor.class, 1L);
            professor.getStudents().size();
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
        System.out.println(professor.getStudents());
    }
}
