package org.heap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TXTReader {
    /**
     * Lee un archivo con formato:
     * Nombre, descripcion, Prioridad
     */
    public List<Paciente> leerPacientes(File ruta) {
        List<Paciente> pacientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(ruta), StandardCharsets.UTF_8))) {

            String linea;
            int numeroLinea = 0;

            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                String[] partes = linea.split(",");
                if (partes.length != 3) {
                    throw new IllegalArgumentException("Línea " + numeroLinea +
                            " inválida (se esperaban 3 campos separados por comas): " + linea);
                }

                String nombre = partes[0].trim();
                String enfermedad = partes[1].trim();
                String prioridadStr = partes[2].trim().toUpperCase();

                if (prioridadStr.isEmpty()) {
                    throw new IllegalArgumentException("Línea " + numeroLinea +
                            " inválida (prioridad vacía): " + linea);
                }

                char prioridad = prioridadStr.charAt(0);
                if (prioridad < 'A' || prioridad > 'E') {
                    throw new IllegalArgumentException("Línea " + numeroLinea +
                            " inválida (prioridad debe ser A-E): " + linea);
                }

                pacientes.add(new Paciente(nombre, enfermedad, prioridad));
            }

        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo: " + e.getMessage(), e);
        }

        return pacientes;
    }
}