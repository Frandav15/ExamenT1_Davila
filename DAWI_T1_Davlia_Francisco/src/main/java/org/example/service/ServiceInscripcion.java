package org.example.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entity.Curso;
import org.example.entity.Estudiante;
import org.example.entity.Inscripcion;

import java.util.Date;
import java.util.List;

public class ServiceInscripcion {
    public void registrarInscripciones(EntityManager em, List<Estudiante> estudiantes, List<Curso> cursos) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Inscripcion i1 = new Inscripcion(estudiantes.get(0), cursos.get(0), new Date(), Inscripcion.Estado.CONFIRMADA);
            Inscripcion i2 = new Inscripcion(estudiantes.get(1), cursos.get(1), new Date(), Inscripcion.Estado.PENDIENTE);
            Inscripcion i3 = new Inscripcion(estudiantes.get(2), cursos.get(2), new Date(), Inscripcion.Estado.CANCELADA);
            Inscripcion i4 = new Inscripcion(estudiantes.get(3), cursos.get(3), new Date(), Inscripcion.Estado.CONFIRMADA);
            Inscripcion i5 = new Inscripcion(estudiantes.get(4), cursos.get(4), new Date(), Inscripcion.Estado.PENDIENTE);
            Inscripcion i6 = new Inscripcion(estudiantes.get(5), cursos.get(5), new Date(), Inscripcion.Estado.CONFIRMADA);
            Inscripcion i7 = new Inscripcion(estudiantes.get(6), cursos.get(6), new Date(), Inscripcion.Estado.CANCELADA);
            Inscripcion i8 = new Inscripcion(estudiantes.get(7), cursos.get(7), new Date(), Inscripcion.Estado.PENDIENTE);
            Inscripcion i9 = new Inscripcion(estudiantes.get(8), cursos.get(8), new Date(), Inscripcion.Estado.CONFIRMADA);
            Inscripcion i10 = new Inscripcion(estudiantes.get(9), cursos.get(9), new Date(), Inscripcion.Estado.PENDIENTE);
            Inscripcion i11 = new Inscripcion(estudiantes.get(10), cursos.get(10), new Date(), Inscripcion.Estado.CONFIRMADA);
            Inscripcion i12 = new Inscripcion(estudiantes.get(11), cursos.get(11), new Date(), Inscripcion.Estado.CANCELADA);
            Inscripcion i13 = new Inscripcion(estudiantes.get(12), cursos.get(12), new Date(), Inscripcion.Estado.CONFIRMADA);
            Inscripcion i14 = new Inscripcion(estudiantes.get(13), cursos.get(13), new Date(), Inscripcion.Estado.PENDIENTE);
            Inscripcion i15 = new Inscripcion(estudiantes.get(14), cursos.get(14), new Date(), Inscripcion.Estado.CONFIRMADA);

            em.persist(i1);
            em.persist(i2);
            em.persist(i3);
            em.persist(i4);
            em.persist(i5);
            em.persist(i6);
            em.persist(i7);
            em.persist(i8);
            em.persist(i9);
            em.persist(i10);
            em.persist(i11);
            em.persist(i12);
            em.persist(i13);
            em.persist(i14);
            em.persist(i15);

            tx.commit();
            System.out.println("Inscripciones registradas correctamente.");
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
            System.out.println("no se puedo registrar inscripciones.");
        }
    }
}
