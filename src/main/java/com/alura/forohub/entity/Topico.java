package com.alura.forohub.entity;

import jakarta.persistence.*;

import java.util.Date;

@Table(name = "topicos")
@Entity(name = "Topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private Date fechaCreacion;
    private String estadoDelTopico;
    @ManyToOne
    private Autor autor;
    @ManyToOne
    private Curso curso;

    //Constructores

    public Topico() {
    }

    public Topico(Long id, String titulo, String mensaje, Date fechaCreacion, String estadoDelTopico, Autor autor, Curso curso) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.estadoDelTopico = estadoDelTopico;
        this.autor = autor;
        this.curso = curso;
    }

    //Getter y Setter

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public String getEstadoDelTopico() {
        return estadoDelTopico;
    }

    public Autor getAutor() {
        return autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setEstadoDelTopico(String estadoDelTopico) {
        this.estadoDelTopico = estadoDelTopico;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    //toString


    @Override
    public String toString() {
        return "Topico{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", estadoDelTopico='" + estadoDelTopico + '\'' +
                ", autor=" + autor +
                ", curso=" + curso +
                '}';
    }
}