package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.entity.Estudiante;

import java.util.List;

public class ServiceReportes {

    public void listarIncripciones(EntityManager em) {
        var resultados = em.createQuery(
                "SELECT i.curso.id, i.curso.nombre, COUNT(i), AVG(i.curso.creditos) " +
                        "FROM Inscripcion i GROUP BY i.curso.id, i.curso.nombre", Object[].class
        ).getResultList();

        for (var fila : resultados) {
            System.out.println("Curso ID: " + fila[0]);
            System.out.println("Curso: " + fila[1]);
            System.out.println("Total Inscripciones: " + fila[2]);
            System.out.println("Promedio Créditos: " + fila[3]);
            System.out.println("-------------------------");
        }
    }



    public void estudiantesInscripciones(EntityManager em) {
        try {
            List<Estudiante> estudiantes = em.createQuery(
                            "SELECT e FROM Estudiante e WHERE SIZE(e.inscripciones) > 2", Estudiante.class)
                    .getResultList();

            if (estudiantes.isEmpty()) {
                System.out.println("No hay estudiantes con más de 2 inscripciones.");
                return;
            }

            System.out.println(" Estudiantes con más de 2 cursos:");
            for (Estudiante e : estudiantes) {
                System.out.println("Nombre: " + e.getNombre() +
                        " | Email: " + e.getEmail() +
                        " | Total Cursos: " + e.getInscripciones().size());
            }
        } catch (Exception e) {
            System.out.println("Error al consultar estudiantes con más de 2 cursos: " + e.getMessage());
        }
    }


    public void estudiantesConMasDeDosCursos(EntityManager em) {
        var resultados = em.createQuery(
                "SELECT i.estudiante.nombre, i.estudiante.email, COUNT(DISTINCT i.curso) " +
                        "FROM Inscripcion i " +
                        "GROUP BY i.estudiante " +
                        "HAVING COUNT(DISTINCT i.curso) > 2", Object[].class
        ).getResultList();

        for (var fila : resultados) {
            System.out.println("Nombre: " + fila[0]);
            System.out.println("Email: " + fila[1]);
            System.out.println("Cursos inscritos: " + fila[2]);
            System.out.println("-------------------------");
        }
    }







}
