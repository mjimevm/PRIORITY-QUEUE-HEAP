package org.heap;

public class Paciente implements Comparable<Paciente>{
    private String nombre;
    private String enfermedad;
    private char nivelPrioridad;

    public Paciente(String nombre, String enfermedad, char nivelPrioridad) {
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
    public char getNivelPrioridad() {
        return nivelPrioridad;
    }
    @Override
    public int compareTo(Paciente otro) {
        return Character.compare(this.nivelPrioridad, otro.nivelPrioridad);
    }
    @Override 
    public String toString() {
        return String.format("Paciente: %s, Enfermedad: %s, Prioridad: %s", nombre, enfermedad, nivelPrioridad);
    }
}
