package org.example.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "inscripcion")
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "fechaInscripcion")
    private Date FechaInscrpcion;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    public Inscripcion(Long id, Estudiante estudiante, Curso curso, Date fechaInscrpcion) {
        Id = id;
        this.estudiante = estudiante;
        this.curso = curso;
        FechaInscrpcion = fechaInscrpcion;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Date getFechaInscrpcion() {
        return FechaInscrpcion;
    }

    public void setFechaInscrpcion(Date fechaInscrpcion) {
        FechaInscrpcion = fechaInscrpcion;
    }


}
