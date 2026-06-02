package Ejercicio4;

import Ejercicio4.Modulos.GestionTarea;
import Ejercicio4.Modulos.Tarea;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionTarea administrador = new GestionTarea();
        Scanner scanner = new Scanner(System.in);
        administrador.cargarTareasPredeterminadas();

        int opcion;

        do {
            System.out.println("Sistema de gestion de tareas pendientes");
            System.out.println("Tareas totales en cola: " + administrador.obtenerCantidadTareas());

            if (administrador.tieneTareasPendientes()) {
                Tarea proxima = administrador.verProximaTarea();
                System.out.println("Próxima a ejecutarse: " + proxima.getDescripcion() + " (" + proxima.getTipo() + ")");
            } else {
                System.out.println("No hay tareas pendientes de ejecución.");
            }
            System.out.println("1. Agregar nueva tarea");
            System.out.println("2. Procesar (ejecutar) siguiente tarea");
            System.out.println("3. Mostrar orden de ejecución completo");
            System.out.println("4. Salir de la aplicación");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la descripción de la tarea: ");
                    String descripcion = scanner.nextLine();

                    System.out.println("Seleccione el tipo de prioridad:");
                    System.out.println("1. Tarea Normal (Va al final)");
                    System.out.println("2. Tarea Urgente (Va al inicio)");
                    System.out.print("Opción: ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    if (tipo == 1 || tipo == 2) {
                        boolean esUrgente = (tipo == 2);
                        administrador.registrarTarea(new Tarea(descripcion, esUrgente));
                        System.out.println("Tarea registrada en su posición correspondiente.");
                    } else {
                        System.out.println("Opción no válida. Registro cancelado.");
                    }
                    break;

                case 2:
                    if (administrador.tieneTareasPendientes()) {
                        Tarea ejecutada = administrador.procesarSiguienteTarea();
                        System.out.println("Prioridad: " + ejecutada.getTipo());
                    } else {
                        System.out.println("No hay tareas pendientes para procesar.");
                    }
                    break;

                case 3:
                    List<String> ordenEjecucion = administrador.obtenerOrdenEjecucionFormateado();

                    if (ordenEjecucion.isEmpty()) {
                        System.out.println("La cola de tareas está vacía.");
                    } else {
                        System.out.println("Orden de ejecución actual (Frente -> Final):");
                        for (String linea : ordenEjecucion) {
                            System.out.println(linea);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del administrador de tareas.");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            System.out.println();

        } while (opcion != 4);

        scanner.close();
    }
}