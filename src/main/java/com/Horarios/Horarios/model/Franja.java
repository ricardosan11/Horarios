package com.Horarios.Horarios.model;

import java.time.LocalTime;

public enum Franja {

    FRANJA1(LocalTime.of(6,00,00), "Franja 1"),
    FRANJA2(LocalTime.of(6,45,00), "Franja 2"),
    FRANJA3(LocalTime.of(7,30,00), "Franja 3"),
    FRANJA4(LocalTime.of(8,15,00), "Franja 4"),
    FRANJA5(LocalTime.of(9,00,00), "Franja 5"),
    RECREO(LocalTime.of(9,45,00), "Recreo"),
    FRANJA6(LocalTime.of(10,15,00), "Franja 6"),
    FRANAJ7(LocalTime.of(11,00,00), "Franaj 7"),
    FRANJA8(LocalTime.of(11,45,00), "Franja 8"),
    SALIDA(LocalTime.of(12,30,00), "Salida");

    final LocalTime franja;
    final String validacion;

    Franja(LocalTime franja, String validacion){
        this.franja = franja;
        this.validacion = validacion;
    }

    public LocalTime getFranja(){
        return this.franja;
    }

    public String getValidacion(){
        return this.validacion;
    }
}
