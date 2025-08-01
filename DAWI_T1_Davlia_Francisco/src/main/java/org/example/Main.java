package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Curso;
import org.example.entity.Estudiante;
import org.example.entity.Profesor;
import org.example.service.*;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");
        EntityManager em = emf.createEntityManager();

        try {
            ServiceProfesor serviceProfesor = new ServiceProfesor();
            ServiceCurso serviceCurso = new ServiceCurso();
            ServiceEstudiante serviceEstudiante = new ServiceEstudiante();
            ServiceInscripcion serviceInscripcion = new ServiceInscripcion();
            ServiceReportes serviceReportes = new ServiceReportes();



            serviceProfesor.crearProfesores(em);

            List<Profesor> profesores = em.createQuery("SELECT p FROM Profesor p", Profesor.class).getResultList();
            serviceCurso.insertarCursos(em, profesores);

            serviceEstudiante.crearEstudiantes(em);

            List<Estudiante> estudiantes = em.createQuery("SELECT e FROM Estudiante e", Estudiante.class).getResultList();
            List<Curso> cursos = em.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();
            serviceInscripcion.registrarInscripciones(em, estudiantes, cursos);

            System.out.println(" Todos los registros fueron insertados correctamente.");


            System.out.println("Inscripciones por curso");
            serviceReportes.listarIncripciones(em);

            System.out.println("Estudiantes y sus incripciones");
            serviceReportes.estudiantesInscripciones(em);

            System.out.println("Estudiantes y incripciones ordenado");
            serviceReportes.estudiantesConMasDeDosCursos(em);
        } catch (Exception e) {
            System.err.println(" Error general: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}