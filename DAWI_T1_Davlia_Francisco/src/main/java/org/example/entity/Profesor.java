package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name  = "profesor")

public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String Nombre;

    @Column(name = "especialidad", length = 100, nullable = false)
    private String Especialidad;

    @ManyToMany(mappedBy = "profesores")
    private List<Curso> cursos;

    public Profesor(Long id, List<Curso> cursos, String especialidad, String nombre) {
        Id = id;
        this.cursos = cursos;
        Especialidad = especialidad;
        Nombre = nombre;
    }


    public Profesor(String nombre, String especialidad) {
        this.Nombre = nombre;
        this.Especialidad = especialidad;
    }

    public  Profesor(){}
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        Especialidad = especialidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
