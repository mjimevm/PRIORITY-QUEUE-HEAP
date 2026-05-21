package org.heap;

public class Paciente {
    private String nombre;
    private String enfermedad;
    private String nivelPrioridad;

    public Paciente(String nombre, String enfermedad, String nivelPrioridad) {
        this.nombre = nombre;
        this.enfermedad = enfermedad;
        this.nivelPrioridad = nivelPrioridad;
    }
    public String getNombre() {
        return nombre;
    }
    public String getEnfermedad() {
        return enfermedad;
    }
    public String getNivelPrioridad() {
        return nivelPrioridad;
    }
    
}
