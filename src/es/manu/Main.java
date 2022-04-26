package es.manu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int tamano, opcion , resultado;
        char[] bombas, casillas;

        do {
            System.out.print("Dime el tamaño del buscaminas [5 a 10]: ");
            tamano = entrada.nextInt();
        } while (tamano > 10 || tamano < 5);
        System.out.println();
        casillas = new char[tamano];

        bombas = crearTablero(tamano);
        crearTablaVacia(casillas);

        crearTabla(bombas);

        do{
            System.out.print("¿Donde crees que hay bomba? (0 para terminar): ");
            opcion = entrada.nextInt();

            resultado = comprobarPosicion(opcion, bombas);
            /* resultado = 0 ha terminado
            resultado = 1 ha acertado
            resultado 2 ha dado a bomba
            */
            if (resultado == 2) {
                opcion = 0;
                System.out.println("has pillaou bombica");
            } else {
                System.out.println("ahi no bomba");
            }
        } while (opcion != 0);

    }

    private static char[] crearTablero (int tamano) {
        char[] tablero = new char[tamano];
        int bombas, contador;

        for (int i = 0; i < tamano; i++) {
            bombas = (int) (Math.random() * 2);
            if (bombas != 0) {
                tablero[i] = '0';
            } else {
                tablero[i] = '*';
            }
        }

        for (int i = 0; i < tamano; i++) {
            contador = 0;
            if (tablero[i] != '*') {
                if (i != 0  && tablero[i - 1] == '*') {
                    contador++;
                }
                if (i != tamano - 1 && tablero[i + 1] == '*') {
                    contador++;
                }
                tablero[i] = String.valueOf(contador).charAt(0);
            }
        }
        return tablero;
    }

    private static void crearTabla (char [] bombas) {

        for (int i = 0; i < bombas.length; i++) {
            System.out.print(" -- " + (i + 1) + " -- ");
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < bombas.length; i++) {
            System.out.print("---------");
        }
        System.out.println();

        for (int i = 0; i < bombas.length; i++) {
            System.out.print("|        ");
        }
        System.out.println("|");

        for (int i = 0; i < bombas.length; i++) {
            System.out.print("|    " + bombas[i] + "   ");
        }
        System.out.println("|");

        for (int i = 0; i < bombas.length; i++) {
            System.out.print("|        ");
        }
        System.out.println("|");

        for (int i = 0; i < bombas.length; i++) {
            System.out.print("---------");
        }
        System.out.println();

    }
    private static void crearTablaVacia (char [] bombas) {

        for (int i = 0; i < bombas.length; i++) {
            System.out.print(" -- " + (i + 1) + " -- ");
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < bombas.length; i++) {
            System.out.print("---------");
        }
        System.out.println();

        for (int i = 0; i < bombas.length; i++) {
            System.out.print("|        ");
        }
        System.out.println("|");

        for (int i = 0; i < bombas.length; i++) {
            System.out.print("|    ·   ");
        }
        System.out.println("|");

        for (int i = 0; i < bombas.length; i++) {
            System.out.print("|        ");
        }
        System.out.println("|");

        for (int i = 0; i < bombas.length; i++) {
            System.out.print("---------");
        }
        System.out.println();

    }

    private static int comprobarPosicion (int posicion, char[] bombas) {

        if (posicion == 0) return 0;

        if (bombas[posicion - 1] == '*') {
            return 2;
        } else  {
            return 1;
        }

    }

}