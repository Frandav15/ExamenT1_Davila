package org.example.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entity.Curso;
import org.example.entity.Estudiante;
import org.example.entity.Inscripcion;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ServiceInscripcion {

    public void registrarInscripciones(EntityManager em, List<Estudiante> estudiantes, List<Curso> cursos) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Inscripcion i1 = new Inscripcion(estudiantes.get(0), cursos.get(0), toDate(LocalDate.of(2024, 1, 5)), Inscripcion.Estado.CONFIRMADA);
            Inscripcion i2 = new Inscripcion(estudiantes.get(1), cursos.get(1), toDate(LocalDate.of(2024, 1, 10)), Inscripcion.Estado.PENDIENTE);
            Inscripcion i3 = new Inscripcion(estudiantes.get(2), cursos.get(2), toDate(LocalDate.of(2024, 1, 15)), Inscripcion.Estado.CANCELADA);
            Inscripcion i4 = new Inscripcion(estudiantes.get(3), cursos.get(3), toDate(LocalDate.of(2024, 1, 20)), Inscripcion.Estado.CONFIRMADA);
            Inscripcion i5 = new Inscripcion(estudiantes.get(4), cursos.get(4), toDate(LocalDate.of(2024, 1, 25)), Inscripcion.Estado.PENDIENTE);
            Inscripcion i6 = new Inscripcion(estudiantes.get(5), cursos.get(5), toDate(LocalDate.of(2024, 2, 1)), Inscripcion.Estado.CONFIRMADA);
            Inscripcion i7 = new Inscripcion(estudiantes.get(6), cursos.get(6), toDate(LocalDate.of(2024, 2, 5)), Inscripcion.Estado.CANCELADA);
            Inscripcion i8 = new Inscripcion(estudiantes.get(7), cursos.get(7), toDate(LocalDate.of(2024, 2, 10)), Inscripcion.Estado.PENDIENTE);
            Inscripcion i9 = new Inscripcion(estudiantes.get(8), cursos.get(8), toDate(LocalDate.of(2024, 2, 15)), Inscripcion.Estado.CONFIRMADA);
            Inscripcion i10 = new Inscripcion(estudiantes.get(9), cursos.get(9), toDate(LocalDate.of(2024, 2, 20)), Inscripcion.Estado.PENDIENTE);
            Inscripcion i11 = new Inscripcion(estudiantes.get(10), cursos.get(10), toDate(LocalDate.of(2024, 2, 25)), Inscripcion.Estado.CONFIRMADA);
            Inscripcion i12 = new Inscripcion(estudiantes.get(11), cursos.get(11), toDate(LocalDate.of(2024, 3, 1)), Inscripcion.Estado.CANCELADA);
            Inscripcion i13 = new Inscripcion(estudiantes.get(12), cursos.get(12), toDate(LocalDate.of(2024, 3, 5)), Inscripcion.Estado.CONFIRMADA);
            Inscripcion i14 = new Inscripcion(estudiantes.get(13), cursos.get(13), toDate(LocalDate.of(2024, 3, 10)), Inscripcion.Estado.PENDIENTE);
            Inscripcion i15 = new Inscripcion(estudiantes.get(14), cursos.get(14), toDate(LocalDate.of(2024, 3, 15)), Inscripcion.Estado.CONFIRMADA);

            List<Inscripcion> inscripcions = Arrays.asList(i1, i2, i3, i4,
                    i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15);

            for (Inscripcion inscripcion : inscripcions) {
                em.persist(inscripcion);
            }

            tx.commit();
            System.out.println("Inscripciones registradas correctamente.");
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
            System.out.println("No se pudo registrar inscripciones.");
        }
    }

    private Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());
    }
}
