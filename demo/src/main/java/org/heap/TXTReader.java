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
    public List<String> leerLineas(File ruta) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(ruta), StandardCharsets.UTF_8))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (!linea.isEmpty()) lines.add(linea);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo: " + e.getMessage(), e);
        }
        return lines;
    }
}