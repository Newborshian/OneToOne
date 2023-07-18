package org.formation.hibernate.client;

import org.formation.hibernate.entity.Professor;
import org.formation.hibernate.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestClientCreateProfessor {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();


        try {
            entityTransaction.begin();
            Professor professor = new Professor();
            professor.setName("Juliette");
            professor.setStaffId("Coucou je suis le deuxième professeur");
            professor.setSalary(1800);
            Student student = entityManager.find(Student.class, 1L);
            professor.getStudents().add(student);
            entityManager.persist(professor);
            entityTransaction.commit();
            System.out.println(professor);

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
