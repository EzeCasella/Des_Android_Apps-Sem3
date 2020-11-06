package com.example.mascotassem3.model;

public class Mascota {

    private int id;
    private Integer imagen;
    private String nombre;
    private Integer puntaje;

    public Mascota(Integer imagen, String nombre, Integer puntaje) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    public Mascota() {

    }

    public Integer getImagen() {
        return imagen;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
