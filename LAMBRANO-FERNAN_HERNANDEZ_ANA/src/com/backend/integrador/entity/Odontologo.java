package com.backend.integrador.entity;

public class Odontologo {
    private int Id;
    private int numeroMatricula;
    private String nombre;
    private String apellido;

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public int getNumeroMatricula() {
        return numeroMatricula;
    }
    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    // Constructor, getters y setters
}