package org.heap;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    private static final String RUTA_PACIENTES = "demo/src/main/resources/pacientes.txt";

    public static void main(String[] args) {
        VectorHeap<Paciente> heapPacientes = new VectorHeap<>();
        TXTReader reader = new TXTReader();

        // 1) Cargar pacientes desde archivo
        try {
            List<Paciente> pacientes = reader.leerPacientes(new File(RUTA_PACIENTES));
            for (Paciente p : pacientes) {
                heapPacientes.insert(p);
            }
            System.out.println("Se cargaron " + heapPacientes.size() + " pacientes desde " + RUTA_PACIENTES);
        } catch (RuntimeException ex) {
            System.out.println("No se pudo cargar el archivo: " + ex.getMessage());
            System.out.println("El programa continuará con el heap vacío.");
        }

        // 2) Menú interactivo
        try (Scanner teclado = new Scanner(System.in)) {
            int opcion = 0;
            while (opcion != 4) {
                System.out.println("\n===== EMERGENCIAS =====");
                System.out.println("1. Insertar paciente");
                System.out.println("2. Atender (eliminar) paciente con mayor prioridad");
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
                    case 1 -> insertarPaciente(teclado, heapPacientes);
                    case 2 -> atenderPaciente(heapPacientes);
                    case 3 -> mostrarSiguiente(heapPacientes);
                    case 4 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida. Usa 1-4.");
                }
            }
        }
    }

    private static void insertarPaciente(Scanner teclado, VectorHeap<Paciente> heap) {
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

        heap.insert(new Paciente(nombre, enfermedad, prioridad));
        System.out.println("Paciente insertado. Total en cola: " + heap.size());
    }

    private static void atenderPaciente(VectorHeap<Paciente> heap) {
        if (heap.isEmpty()) {
            System.out.println("No hay pacientes en el heap.");
            return;
        }
        try {
            Paciente atendido = heap.removeMin();
            System.out.println("Atendiendo a: " + atendido);
        } catch (NoSuchElementException e) {
            System.out.println("No hay pacientes en el heap.");
        }
    }

    private static void mostrarSiguiente(VectorHeap<Paciente> heap) {
        if (heap.isEmpty()) {
            System.out.println("No hay pacientes en el heap.");
            return;
        }
        try {
            System.out.println("Siguiente paciente: " + heap.peekMin());
        } catch (NoSuchElementException e) {
            System.out.println("No hay pacientes en el heap.");
        }
    }
}