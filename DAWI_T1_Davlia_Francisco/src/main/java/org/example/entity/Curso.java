package org.example.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String Nombre;

    @Column(name = "codigo", length = 20, nullable = false)
    private String Codigo;

    @Column(name = "creditos")
    private int Creditos;

    @ManyToMany
    @JoinTable(name = "Curso_Profesor", joinColumns = @JoinColumn(name = "curso_id"), inverseJoinColumns =   @JoinColumn(name = "profesor_id"))
    private List<Profesor>profesores;

    @OneToMany(mappedBy = "curso")
    private List<Inscripcion>inscripciones;

    public Curso(Long id, List<Inscripcion> inscripciones, List<Profesor> profesores, int creditos, String codigo, String nombre) {
        Id = id;
        this.inscripciones = inscripciones;
        this.profesores = profesores;
        Creditos = creditos;
        Codigo = codigo;
        Nombre = nombre;
    }

    public Curso(String nombre, String codigo, int creditos) {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public int getCreditos() {
        return Creditos;
    }

    public void setCreditos(int creditos) {
        Creditos = creditos;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
