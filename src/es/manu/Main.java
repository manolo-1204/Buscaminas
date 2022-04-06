package es.manu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int tamano;
        char[] tabla;

        System.out.println("Dime el tamaño del buscaminas [5 a 20]: ");
        tamano = entrada.nextInt();

        tabla = crearTablero(tamano);

        System.out.println(tabla);

    }

    private static char[] crearTablero (int tamano) {
        char[] tablero = new char[tamano];
        int bombas;
        for (int i = 0; i < tamano; i++) {
            bombas = (int) (Math.random() * 2);
            if (bombas != 0) {
                tablero[i] += 0;
            } else {
                tablero[i] += '*';
            }
        }

        for (int i = 0; i < tamano; i++) {
            int contador = 0;
            if (tablero[i] != '*') {
                if (tablero[i - 1] == '*' && i != 0) {
                    contador++;
                }
                if (tablero[i + 1] == '*' && i != tamano - 1) {
                    contador++;
                }
                tablero[i] = (char) contador;
            }
        }
        return tablero;
    }

    /*private static void  (int tamano){
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < 4; j ++) {
                if ()
                System.out.print("+");
            }
        }*/














        /*for (int i = 0; i < tamano; i++){
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 6; k++) {
                    if (k == 0 || k == 5) {
                        System.out.print("|");
                    } else if (j == 0 || (i == tamano - 1 && j == 3)) {
                        System.out.print("--");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
        }
    }*/
}
