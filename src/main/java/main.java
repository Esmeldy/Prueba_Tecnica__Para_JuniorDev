import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        char [][] mapa = new char[10][10];
        int fila;
        int columna;
        boolean exit = false;
        Scanner sc = new Scanner(System.in);

        iniciarFilasAsientos(mapa);
       // mostrarFilasAsientos(mapa);

        System.out.println("******************* Iniciar Sistema de Reservas *******************");

        while (!exit){
            mostrarFilasAsientos(mapa);
            System.out.println("Ingrese la fila que desea: ( De 1 a 10)");
            fila = sc.nextInt();
            if (fila < 1 || fila > 10) {
                System.out.println("Fila no válida\n");
                System.out.println("Prueba de nuevo");
                fila = sc.nextInt();
            }

            System.out.println("Ingrese el asiento que desea: ( De 1 a 10)");
            columna = sc.nextInt();

            if (columna < 1 || columna > 10) {
                System.out.println("Asiento no válido\n");
                System.out.println("Prueba de nuevo");
                columna = sc.nextInt();
            }

            if (reservarAsiento(fila-1, columna-1, mapa)){
                System.out.println("Asiento reservado correctamente");
            }else {
                System.out.println("El asiento ya está reservado, prueba con otro.");
            }

            System.out.println("¿Deseas finalizar la reserva? (S: si Cualquier otra letra: No)");
            String respuesta = sc.next();
            if (respuesta.equalsIgnoreCase("S")){
                exit = true;
                System.out.println("****************************  Hasta pronto   ****************************");
            }

        }

    }

    private static boolean reservarAsiento(int fila, int col, char[][] mapa) {
        if ('X' == mapa[fila][col]){
            return false;
        }else {
            mapa[fila][col] = 'X';
            return true;
        }
    }


    public static void iniciarFilasAsientos(char[][] mapa) {
        for (char[] chars : mapa) {
            Arrays.fill(chars, 'L');
        }
    }
    public static void mostrarFilasAsientos(char[][] mapa) {
        System.out.println();
        for (int i = 0; i < mapa.length; i++) {
            System.out.print("Fila: "+(i+1)+": ");
            for (int j = 0; j < mapa[i].length; j++) {
                System.out.print("["+mapa[i][j]+"] ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
