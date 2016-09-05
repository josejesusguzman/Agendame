package com.example.jose_jesus_guzman.agendame.Activities.Views.Clases;

/**
 * Created by jesus on 4/09/16.
 */
public class CursoCompleto {

    private String nombreCurso;

    private int inicioDia;
    private int inicioMes;
    private int inicioAnio;
    private int finDia;
    private int finMes;
    private int finAnio;

    private int inicioHora;
    private int inicioMinutos;
    private int finHora;
    private int finMinutos;

    private int sabInicioDia;
    private int sabInicioMes;
    private int sabInicioAnio;
    private int sabFinDia;
    private int sabFinMes;
    private int sabFinAnio;

    private int sabInicioHora;
    private int sabInicioMinutos;
    private int sabFinHora;
    private int sabFinMinutos;

    private int costoCurso;
    private int duracionCurso;
    private int aperturaCurso;

    public CursoCompleto(String nombreCurso, int inicioDia, int inicioMes, int inicioAnio,
                         int finDia, int finMes, int finAnio, int inicioHora, int inicioMinutos,
                         int finHora, int finMinutos, int sabInicioDia, int sabInicioMes,
                         int sabInicioAnio, int sabFinDia, int sabFinMes, int sabFinAnio,
                         int sabInicioHora, int sabInicioMinutos, int sabFinHora,
                         int sabFinMinutos, int costoCurso, int duracionCurso, int aperturaCurso) {

        this.nombreCurso = nombreCurso;
        this.inicioDia = inicioDia;
        this.inicioMes = inicioMes;
        this.inicioAnio = inicioAnio;
        this.finDia = finDia;
        this.finMes = finMes;
        this.finAnio = finAnio;
        this.inicioHora = inicioHora;
        this.inicioMinutos = inicioMinutos;
        this.finHora = finHora;
        this.finMinutos = finMinutos;
        this.sabInicioDia = sabInicioDia;
        this.sabInicioMes = sabInicioMes;
        this.sabInicioAnio = sabInicioAnio;
        this.sabFinDia = sabFinDia;
        this.sabFinMes = sabFinMes;
        this.sabFinAnio = sabFinAnio;
        this.sabInicioHora = sabInicioHora;
        this.sabInicioMinutos = sabInicioMinutos;
        this.sabFinHora = sabFinHora;
        this.sabFinMinutos = sabFinMinutos;
        this.costoCurso = costoCurso;
        this.duracionCurso = duracionCurso;
        this.aperturaCurso = aperturaCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public int getInicioDia() {
        return inicioDia;
    }

    public int getInicioMes() {
        return inicioMes;
    }

    public int getInicioAnio() {
        return inicioAnio;
    }

    public int getFinDia() {
        return finDia;
    }

    public int getFinMes() {
        return finMes;
    }

    public int getFinAnio() {
        return finAnio;
    }

    public int getInicioHora() {
        return inicioHora;
    }

    public int getInicioMinutos() {
        return inicioMinutos;
    }

    public int getFinHora() {
        return finHora;
    }

    public int getFinMinutos() {
        return finMinutos;
    }

    public int getSabInicioDia() {
        return sabInicioDia;
    }

    public int getSabInicioMes() {
        return sabInicioMes;
    }

    public int getSabInicioAnio() {
        return sabInicioAnio;
    }

    public int getSabFinDia() {
        return sabFinDia;
    }

    public int getSabFinMes() {
        return sabFinMes;
    }

    public int getSabFinAnio() {
        return sabFinAnio;
    }

    public int getSabInicioHora() {
        return sabInicioHora;
    }

    public int getSabInicioMinutos() {
        return sabInicioMinutos;
    }

    public int getSabFinHora() {
        return sabFinHora;
    }

    public int getSabFinMinutos() {
        return sabFinMinutos;
    }

    public int getCostoCurso() {
        return costoCurso;
    }

    public int getDuracionCurso() {
        return duracionCurso;
    }

    public int getAperturaCurso() {
        return aperturaCurso;
    }
}
