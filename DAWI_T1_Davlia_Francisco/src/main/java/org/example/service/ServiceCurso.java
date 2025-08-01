package org.example.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entity.Curso;
import org.example.entity.Profesor;
import java.util.List;

import java.util.Arrays;

public class ServiceCurso {
    public void insertarCursos(EntityManager em, List<Profesor> profesores) {
        EntityTransaction tx = em.getTransaction();
        try {

        tx.begin();
        Curso c1 = new Curso("Álgebra", "MAT101", 4);
        c1.setProfesores(Arrays.asList(profesores.get(0), profesores.get(1)));

        Curso c2 = new Curso("Literatura", "COM102", 3);
        c2.setProfesores(Arrays.asList(profesores.get(2)));

        Curso c3 = new Curso("Física I", "FIS103", 4);
        c3.setProfesores(Arrays.asList(profesores.get(0)));

        Curso c4 = new Curso("Química General", "QUI104", 4);
        c4.setProfesores(Arrays.asList(profesores.get(1)));

        Curso c5 = new Curso("Historia del Perú", "HIS105", 3);
        c5.setProfesores(Arrays.asList(profesores.get(2)));

        Curso c6 = new Curso("Programación I", "INF106", 5);
        c6.setProfesores(Arrays.asList(profesores.get(3), profesores.get(4)));

        Curso c7 = new Curso("Estadística", "EST107", 4);
        c7.setProfesores(Arrays.asList(profesores.get(0)));

        Curso c8 = new Curso("Cálculo Diferencial", "MAT108", 4);
        c8.setProfesores(Arrays.asList(profesores.get(1)));

        Curso c9 = new Curso("Biología", "BIO109", 3);
        c9.setProfesores(Arrays.asList(profesores.get(2)));

        Curso c10 = new Curso("Filosofía", "FIL110", 3);
        c10.setProfesores(Arrays.asList(profesores.get(3)));

        Curso c11 = new Curso("Economía", "ECO111", 3);
        c11.setProfesores(Arrays.asList(profesores.get(4)));

        Curso c12 = new Curso("Inglés Intermedio", "IDI112", 2);
        c12.setProfesores(Arrays.asList(profesores.get(0)));

        Curso c13 = new Curso("Sociología", "SOC113", 3);
        c13.setProfesores(Arrays.asList(profesores.get(1)));

        Curso c14 = new Curso("Psicología General", "PSI114", 3);
        c14.setProfesores(Arrays.asList(profesores.get(2)));

        Curso c15 = new Curso("Educación Física", "EDF115", 2);
        c15.setProfesores(Arrays.asList(profesores.get(3)));

        List<Curso> cursos = Arrays.asList(c1, c2, c3, c4,
                c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15);
            for (Curso curso : cursos) {
                em.persist(curso);
            }

        tx.commit();
            System.out.println("Cursos registradas correctamente.");
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
            System.out.println("no se puedo registrar cursos.");
        }
    }

}
