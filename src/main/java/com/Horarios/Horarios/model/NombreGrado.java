package com.Horarios.Horarios.model;

public enum NombreGrado {

    PRIMERO("Primero", "1"),
    SEGUNDO("Segundo", "2"),
    TERCERO("Tercero", "3"),
    CUARTO("Cuarto", "4"),
    QUINTO("Quinto", "5"),
    SEXTO("Sexto", "6"),
    SEPTIMO("Septimo", "7"),
    OCTAVO("Octavo", "8"),
    NOVENO("Noveno", "9"),
    DECIMO("Decimo", "10"),
    UNDECIMO("Undecimo", "11");

    final String nombre;
    final String numeracion;

    NombreGrado(String nombre, String numeracion){
        this.nombre = nombre;
        this.numeracion = numeracion;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getNumeracion(){
        return this.numeracion;
    }

}
