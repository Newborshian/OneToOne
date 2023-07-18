package org.formation.hibernate.client;

import org.formation.hibernate.entity.Professor;
import org.formation.hibernate.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestClientCreateStudent {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            Student student = new Student();
            student.setName("Babybel3");
            student.setEnrollmentId("Coucou je suis le Cinquième étudiant");
            //Persistence en cascade
            Professor professor = entityManager.find(Professor.class, 2L);
            professor.addStudent(student);
            entityManager.persist(student);
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
