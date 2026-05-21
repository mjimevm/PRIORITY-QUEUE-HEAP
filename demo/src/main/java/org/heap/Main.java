package org.heap;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        TXTReader reader = new TXTReader();
        List<String> lineas = reader.leerLineas(new File("src/main/resources/heap.txt"));
    }
}