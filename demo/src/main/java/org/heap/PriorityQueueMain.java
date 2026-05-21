package org.heap;

import java.io.File;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueMain {

    private static final String RUTA_PACIENTES = "src/main/resources/pacientes.txt";

    public static void main(String[] args) {
        PriorityQueue<Paciente> colaPacientes = new PriorityQueue<>();
        TXTReader reader = new TXTReader();

        // Cargar pacientes desde archivo
        try {
            List<Paciente> pacientes = reader.leerPacientes(new File(RUTA_PACIENTES));
            colaPacientes.addAll(pacientes);
            System.out.println("Se cargaron " + colaPacientes.size() + " pacientes desde " + RUTA_PACIENTES);
        } catch (RuntimeException ex) {
            System.out.println("No se pudo cargar el archivo: " + ex.getMessage());
            System.out.println("El programa continuará con la cola vacía.");
        }

        // Menú
        try (Scanner teclado = new Scanner(System.in)) {
            int opcion = 0;
            while (opcion != 4) {
                System.out.println("\n===== EMERGENCIAS (JCF PriorityQueue) =====");
                System.out.println("1. Insertar paciente");
                System.out.println("2. Atender paciente con mayor prioridad");
                System.out.println("3. Mostrar paciente con mayor prioridad");
                System.out.println("4. Salir");
                System.out.print("Elige una opción: ");

                String entrada = teclado.nextLine().trim();
                try {
                    opcion = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("Opción inválida. Ingresa un número del 1 al 4.");
                    continue;
                }

                switch (opcion) {
                    case 1 -> insertarPaciente(teclado, colaPacientes);
                    case 2 -> atenderPaciente(colaPacientes);
                    case 3 -> mostrarSiguiente(colaPacientes);
                    case 4 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida. Usa 1-4.");
                }
            }
        }
    }
    /**
     * Inserta un nuevo paciente en la cola de prioridad.
     * @param teclado Scanner para leer la entrada del usuario
     * @param cola La cola de prioridad donde se insertará el paciente
     */
    private static void insertarPaciente(Scanner teclado, PriorityQueue<Paciente> cola) {
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine().trim();

        System.out.print("Síntoma/Enfermedad: ");
        String enfermedad = teclado.nextLine().trim();

        char prioridad;
        while (true) {
            System.out.print("Prioridad (A-E): ");
            String p = teclado.nextLine().trim().toUpperCase();
            if (p.isEmpty()) {
                System.out.println("Prioridad vacía. Intenta de nuevo.");
                continue;
            }
            prioridad = p.charAt(0);
            if (prioridad < 'A' || prioridad > 'E') {
                System.out.println("Prioridad inválida. Debe ser A, B, C, D o E.");
                continue;
            }
            break;
        }

        cola.offer(new Paciente(nombre, enfermedad, prioridad));
        System.out.println("Paciente insertado. Total en cola: " + cola.size());
    }
    /**
     * Atiende al paciente con mayor prioridad en la cola.
     * @param cola La cola de prioridad
     */
    private static void atenderPaciente(PriorityQueue<Paciente> cola) {
        Paciente atendido = cola.poll(); // null si está vacía
        if (atendido == null) {
            System.out.println("No hay pacientes en la cola.");
            return;
        }
        System.out.println("Atendiendo a: " + atendido);
    }
    /**
     * Muestra el paciente con mayor prioridad sin eliminarlo de la cola.
     * @param cola La cola de prioridad
     */
    private static void mostrarSiguiente(PriorityQueue<Paciente> cola) {
        Paciente siguiente = cola.peek(); // null si está vacía
        if (siguiente == null) {
            System.out.println("No hay pacientes en la cola.");
            return;
        }
        System.out.println("Siguiente paciente: " + siguiente);
    }
}