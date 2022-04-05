package es.manu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int tamano;

        System.out.println("Dime el tamaño del buscaminas [5 a 20]: ");
        tamano = entrada.nextInt();

        crearTablero(tamano);

    }

    private static void crearTablero (int tamano){
        for (int i = 0; i < tamano; i++){
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 6; k++) {
                    if (k == 0 || k == 5) {
                        System.out.print("+");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
        }
    }
}
