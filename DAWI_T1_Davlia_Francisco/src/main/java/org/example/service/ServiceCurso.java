package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.entity.Curso;
import org.example.entity.Profesor;
import org.hibernate.mapping.List;

import java.util.Arrays;

public class ServiceCurso {
    public void insertarCursos(EntityManager em, java.util.List<Profesor> profesores) {
        em.getTransaction().begin();

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



        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);
        em.persist(c5);
        em.persist(c6);
        em.persist(c7);
        em.persist(c8);
        em.persist(c9);
        em.persist(c10);
        em.persist(c11);
        em.persist(c12);
        em.persist(c13);
        em.persist(c14);
        em.persist(c15);

        em.getTransaction().commit();
    }

}
