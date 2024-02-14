import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GeneradorNumerosAleatoriosUMG {
    private static final int NUMERO_DE_NUMEROS = 1000000;
    private static final int RANGO_MINIMO = -10000000;
    private static final int RANGO_MAXIMO = 10000000;

    public static void main(String[] args) {
        generarNumerosAleatorios();
        leerYOrdenarNumeros();
    }

    public static void generarNumerosAleatorios() {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter("numeros_aleatorios.txt"));
            BufferedWriter escritorOrdenado = new BufferedWriter(new FileWriter("numeros_aleatorios_ordenados.txt"));

            Random generador = new Random();

            for (int i = 0; i < NUMERO_DE_NUMEROS; i++) {
                int numeroAleatorio = generador.nextInt(RANGO_MAXIMO - RANGO_MINIMO + 1) + RANGO_MINIMO;
                escritor.write(Integer.toString(numeroAleatorio));
                escritor.newLine();
            }

            escritor.close();

            System.out.println("Se han generado y almacenado " + NUMERO_DE_NUMEROS + " números aleatorios en el archivo.");

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void leerYOrdenarNumeros() {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("numeros_aleatorios.txt"));
            BufferedWriter escritorOrdenado = new BufferedWriter(new FileWriter("numeros_aleatorios_ordenados.txt"));

            ArrayList<Integer> numeros = new ArrayList<>();
            String linea;

            // Leer números del archivo
            while ((linea = lector.readLine()) != null) {
                numeros.add(Integer.parseInt(linea));
            }

            // Ordenar los números
            Collections.sort(numeros);

            // Escribir los números ordenados en un nuevo archivo
            for (int numero : numeros) {
                escritorOrdenado.write(Integer.toString(numero));
                escritorOrdenado.newLine();
            }

            lector.close();
            escritorOrdenado.close();

            System.out.println("Se han ordenado y almacenado los números en el archivo 'numeros_aleatorios_ordenados.txt'.");

        } catch (IOException e) {
            System.out.println("Error al leer o escribir en el archivo: " + e.getMessage());
        }
    }
}
