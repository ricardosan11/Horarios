package com.Horarios.Horarios.model;

public enum NombreDia {

    LUNES("Lunes"),
    MARTES("Martes"),
    MIERCOLES("Miercoles"),
    JUEVES("Jueves"),
    VIERNES("Viernes");

    final String nombreDia;

    NombreDia(String nombreDia){
        this.nombreDia = nombreDia;
    }

    public String getNombreDia(){
        return this.nombreDia;
    }

}
