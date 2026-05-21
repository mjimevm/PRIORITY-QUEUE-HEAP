package org.heap;

public class Paciente implements Comparable<Paciente>{
    // Atributos
    private String nombre;
    private String enfermedad;
    private char nivelPrioridad;
    // constructor
    public Paciente(String nombre, String enfermedad, char nivelPrioridad) {
        this.nombre = nombre;
        this.enfermedad = enfermedad;
        this.nivelPrioridad = nivelPrioridad;
    }
    /**
     * Método para obtener el nombre del paciente.
     * @return nombre del paciente
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método para obtener la enfermedad o síntoma del paciente.
     * @return la enfermedad del paciente
     */
    public String getEnfermedad() {
        return enfermedad;
    }
    /**
     * Método para obtener el nivel de prioridad del paciente. El nivel de prioridad se representa como un carácter, donde 'A' es la prioridad más alta y 'E' la más baja.
     * @return el nivel de prioridad del paciente
     */
    public char getNivelPrioridad() {
        return nivelPrioridad;
    }
    /**
     * Método para comparar dos pacientes basado en su nivel de prioridad. Retorna un valor negativo si el paciente actual tiene mayor prioridad (menor carácter) que el otro paciente, un valor positivo si tiene menor prioridad (mayor carácter) y cero si ambos pacientes tienen la misma prioridad.
     * @param otro El paciente con el cual se comparará el paciente actual
     * @return Un valor negativo si el paciente actual tiene mayor prioridad que el otro, un valor positivo si tiene menor prioridad y cero si ambos tienen la misma prioridad
     */
    @Override
    public int compareTo(Paciente otro) {
        return Character.compare(this.nivelPrioridad, otro.nivelPrioridad);
    }
    /**
     * Método para representar el paciente como una cadena de texto. Retorna una cadena que incluye el nombre, la enfermedad y el nivel de prioridad del paciente.
     * @return Una representación en cadena del paciente con su nombre, enfermedad y nivel de prioridad
     */
    @Override 
    public String toString() {
        return String.format("Paciente: %s, Enfermedad: %s, Prioridad: %s", nombre, enfermedad, nivelPrioridad);
    }
}
