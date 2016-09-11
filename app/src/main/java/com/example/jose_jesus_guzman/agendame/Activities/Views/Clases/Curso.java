package com.example.jose_jesus_guzman.agendame.Activities.Views.Clases;

/**
 * Created by jesus on 4/09/16.
 */
public class Curso {

    private int id;
    private String nombre;
    private String fecha; // DD/MM/AAAA
    private String estado; //inscribirse o Proximamente
    private int img; //Imagen a elegir

    public Curso(int id, String nombre, String fecha, String estado, int img) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.estado = estado;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public int getImg() {
        return img;
    }
}
