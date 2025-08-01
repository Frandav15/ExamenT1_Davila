package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.entity.Profesor;

import java.util.Arrays;
import java.util.List;

public class ServiceProfesor {

    public void crearProfesores(EntityManager em) {
        List<Profesor> profesores = Arrays.asList(
                new Profesor("Juan", "Matematicas"),
                new Profesor("Lucía", "Comuni"),
                new Profesor("Pedro", "Compu"),
                new Profesor("Ana", "DDPP"),
                new Profesor("Carlos", "Civica"),
                new Profesor("Sofía", "Ingles"),
                new Profesor("Luis", "Ciencias"),
                new Profesor("María", "Biologia"),
                new Profesor("Andrés", "QUimica"),
                new Profesor("Carmen", "Trigonometria"),
                new Profesor("Daniel", "Talleres"),
                new Profesor("Daniela", "Poesia"),
                new Profesor("Ricardo", "Fisica"),
                new Profesor("Elena", "Geometria"),
                new Profesor("Martín", "Algebra")
        );

        try {
            em.getTransaction().begin();

            for (Profesor prof : profesores) {
                em.persist(prof);
            }

            em.getTransaction().commit();
            System.out.println(" Se insertaron 15 profesore.");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("No se puedo insertar profesores: " + e.getMessage());
        }
    }
}
