package BUSQUEDAS;

import java.util.Scanner;
import java.util.Random;

public class Ahorcao {

    public static void main(String[] args) {
        String[] palabras = {"manzana", "pera", "cereza", "melocoton", "sandia", "kiwi", "mango", "uva", "fresa", "limon"};
        Random random = new Random();
        String palabra = palabras[random.nextInt(palabras.length)];
        int longitud = palabra.length();
        char[] adivinada = new char[longitud];
        boolean[] utilizados = new boolean[26];
        int errores = 0;

        for (int i = 0; i < longitud; i++) {
            adivinada[i] = '_';
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Adivina la palabra!");

        while (errores < 7 && !palabraAdivinada(adivinada)) {
            mostrarAdivinada(adivinada);
            System.out.println("Errores: " + errores);
            char letra = scanner.next().charAt(0);

            if (letra >= 'a' && letra <= 'z') {
                int indice = letra - 'a';

                if (!utilizados[indice]) {
                    utilizados[indice] = true;

                    for (int i = 0; i < longitud; i++) {
                        if (palabra.charAt(i) == letra) {
                            adivinada[i] = letra;
                        }
                    }

                    if (!buscarLetra(adivinada, letra)) {
                        errores++;
                        System.out.println("¡Lo siento! La letra '" + letra + "' no se encuentra en la palabra.");
                    }
                } else {
                    System.out.println("¡Lo siento! La letra '" + letra + "' ya ha sido utilizada.");
                }
            } else {
                System.out.println("¡Por favor ingresa una letra válida!");
            }
        }

        if (errores == 7) {
            System.out.println("¡Lo siento! Te has quedado sin intentos. La palabra era: " + palabra);
        } else {
            System.out.println("¡Felicidades! Adivinaste la palabra: " + palabra);
        }

        scanner.close();
    }

    public static void mostrarAdivinada(char[] adivinada) {
        for (int i = 0; i < adivinada.length; i++) {
            System.out.print(adivinada[i] + " ");
        }
        System.out.println();
    }

    public static boolean palabraAdivinada(char[] adivinada) {
        for (int i = 0; i < adivinada.length; i++) {
            if (adivinada[i] == '_') {
                return false;
            }
        }
        return true;
    }

    public static boolean buscarLetra(char[] adivinada, char letra) {
        for (int i = 0; i < adivinada.length; i++) {
            if (adivinada[i] == letra) {
                return true;
            }
        }
        return false;
    }
}