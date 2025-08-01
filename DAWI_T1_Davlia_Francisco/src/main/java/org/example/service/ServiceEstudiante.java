package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.entity.Estudiante;

import java.util.Arrays;
import java.util.List;

public class ServiceEstudiante {

    public void crearEstudiantes(EntityManager em) {
        List<Estudiante> estudiantes = Arrays.asList(
                new Estudiante("Alonso", "alonso@cibertec.edu.pe", "Julio"),
                new Estudiante("Brenda", "brenda@cibertec.edu.pe", "Agosto"),
                new Estudiante("Camila", "camila@cibertec.edu.pe", "Novienbre"),
                new Estudiante("Diego", "diego@cibertec.edu.pe", "Julio"),
                new Estudiante("Elena", "elena@cibertec.edu.pe", "Julio"),
                new Estudiante("Fabricio", "fabricio@cibertec.edu.pe", "Julio"),
                new Estudiante("Gabriela",  "gabriela@cibertec.edu.pe", "Julio"),
                new Estudiante("Hugo",  "hugo@cibertec.edu.pe", "Julio"),
                new Estudiante("Isabel",  "isabel@cibertec.edu.pe", "Julio"),
                new Estudiante("Javier", "javier@cibertec.edu.pe", "Julio"),
                new Estudiante("Karen",  "karen@cibertec.edu.pe", "Julio"),
                new Estudiante("Leonardo",  "leonardo@cibertec.edu.pe", "Julio"),
                new Estudiante("María",  "maria@cibertec.edu.pe", "Julio"),
                new Estudiante("Nicolás", "nicolas@cibertec.edu.pe", "Julio"),
                new Estudiante("Olga", "olga@cibertec.edu.pe", "Julio")
        );

        try {
            em.getTransaction().begin();

            for (Estudiante est : estudiantes) {
                em.persist(est);
            }

            em.getTransaction().commit();
            System.out.println("Se insertaron 15 estudiantes correctamente.");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("No se puedo insertar estudiantes: " + e.getMessage());
        }
}}
