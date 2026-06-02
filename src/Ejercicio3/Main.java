package Ejercicio3;

import Ejercicio3.Modulos.GestionHospital;
import Ejercicio3.Modulos.Paciente;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionHospital hospital = new GestionHospital();
        Scanner scanner = new Scanner(System.in);

        // Se ejecuta la pre-carga desde el backend de forma directa
        hospital.cargarPacientesPredeterminados();

        int opcion;

        do {
            System.out.println("----------------------------------------------");
            System.out.println("SISTEMA DE PRIORIDADES HOSPITALARIAS");
            System.out.println("Pacientes en sala de espera: " + hospital.obtenerCantidadPacientes());

            if (hospital.tienePacientes()) {
                Paciente proximo = hospital.verSiguientePaciente();
                System.out.println("Próximo en ser llamado: " + proximo.getNombre() + " (" + proximo.getTipoPrioridad() + ")");
            } else {
                System.out.println("No hay pacientes pendientes en este momento.");
            }
            System.out.println("----------------------------------------------");

            System.out.println("1. Registrar nuevo paciente");
            System.out.println("2. Atender siguiente paciente");
            System.out.println("3. Mostrar lista de espera actual");
            System.out.println("4. Salir del sistema");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpieza de búfer
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del paciente: ");
                    String nombre = scanner.nextLine();

                    System.out.println("Seleccione el nivel de gravedad:");
                    System.out.println("1 = Emergencia (Máxima prioridad)");
                    System.out.println("2 = Urgente");
                    System.out.println("3 = Consulta general (Mínima prioridad)");
                    System.out.print("Opción: ");
                    int prioridad = scanner.nextInt();
                    scanner.nextLine();

                    if (prioridad >= 1 && prioridad <= 3) {
                        hospital.registrarPaciente(new Paciente(nombre, prioridad));
                        System.out.println("Paciente registrado con éxito.");
                    } else {
                        System.out.println("Nivel de gravedad no válido. Registro cancelado.");
                    }
                    break;

                case 2:
                    if (hospital.tienePacientes()) {
                        Paciente atendido = hospital.atenderPaciente();
                        System.out.println(">>> ATENDIENDO A: " + atendido.getNombre());
                        System.out.println("Clasificación: " + atendido.getTipoPrioridad());
                    } else {
                        System.out.println("No hay pacientes en la cola para atender.");
                    }
                    break;

                case 3:
                    List<String> listaEspera = hospital.obtenerListaEsperaFormateada();

                    if (listaEspera.isEmpty()) {
                        System.out.println("La lista de espera está vacía.");
                    } else {
                        System.out.println("Pacientes en espera (Ordenados por prioridad de atención):");
                        for (String linea : listaEspera) {
                            System.out.println(linea);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del sistema hospitalario.");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            System.out.println();

        } while (opcion != 4);

        scanner.close();
    }
}