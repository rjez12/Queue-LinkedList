package Ejercicio2;

import Ejercicio2.Modulos.NavegadorWeb;
import Ejercicio2.Modulos.Pagina;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NavegadorWeb navegador = new NavegadorWeb();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Impresión del estado actual del navegador en cada iteración
            System.out.println("Página actual: " + navegador.getUrlActual());

            System.out.print("Historial Atrás: ");
            for (Pagina p : navegador.getHistorialAtras()) {
                System.out.print("[" + p.getUrl() + "] ");
            }
            System.out.println();

            System.out.print("Historial Adelante: ");
            for (Pagina p : navegador.getHistorialAdelante()) {
                System.out.print("[" + p.getUrl() + "] ");
            }

            // Menú de navegación
            System.out.println("1. Visitar nueva página web");
            System.out.println("2. Botón Atrás");
            System.out.println("3. Botón Adelante");
            System.out.println("4. Salir del navegador");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpieza del salto de línea del búfer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la URL o nombre de la página: ");
                    String url = scanner.nextLine();
                    navegador.visitarPagina(new Pagina(url));
                    break;

                case 2:
                    boolean pudoRetroceder = navegador.retroceder();
                    if (!pudoRetroceder) {
                        System.out.println("No hay páginas previas en el historial.");
                    }
                    break;

                case 3:
                    boolean pudoAvanzar = navegador.avanzar();
                    if (!pudoAvanzar) {
                        System.out.println("No hay páginas hacia adelante en el historial.");
                    }
                    break;

                case 4:
                    System.out.println("Cerrando el simulador de navegación web.");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            System.out.println();

        } while (opcion != 4);

        scanner.close();
    }
}