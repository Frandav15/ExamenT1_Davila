package org.example.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String Nombre;

    @Column(name = "email", length = 100, nullable = false)
    private String Email;

    @Column(name = "matricula", length = 20, nullable = false)
    private String Matricula;

    @OneToMany(mappedBy = "estudiante")
    private List<Inscripcion> inscripciones;

    public Estudiante(Long id, List<Inscripcion> inscripciones, String matricula, String email, String nombre) {
        Id = id;
        this.inscripciones = inscripciones;
        Matricula = matricula;
        Email = email;
        Nombre = nombre;
    }

    public Estudiante(String nombre, String email, String matricula) {
        this.Nombre = nombre;
        this.Email = email;
        this.Matricula = matricula;
    }

    public Estudiante(){}



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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }
}
