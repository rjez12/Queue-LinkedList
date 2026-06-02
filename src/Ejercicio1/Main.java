package Ejercicio1;
import Ejercicio1.Modulos.Cliente;
import Ejercicio1.Modulos.GestionBanco;

public class Main {
    public static void main(String[] args) {
        // Instancia del sistema de gestión bancaria
        GestionBanco banco = new GestionBanco();

        // Registro de los 8 clientes requeridos
        banco.registrarCliente(new Cliente("Carlos Gómez"));
        banco.registrarCliente(new Cliente("María López"));
        banco.registrarCliente(new Cliente("Juan Pérez"));
        banco.registrarCliente(new Cliente("Ana Martínez"));
        banco.registrarCliente(new Cliente("Luis Rodríguez"));
        banco.registrarCliente(new Cliente("Sofía Hernández"));
        banco.registrarCliente(new Cliente("Diego Flores"));
        banco.registrarCliente(new Cliente("Elena Torres"));

        System.out.println("Inicio de la simulación de atención bancaria");
        System.out.println("Cantidad inicial de clientes en espera: " + banco.obtenerCantidadClientes());
        System.out.println();

        // Procesamiento de turnos de manera independiente hasta vaciar la cola
        while (banco.tieneClientesEnEspera()) {

            // Inspección del próximo cliente
            Cliente proximo = banco.verSiguienteCliente();
            System.out.println("Siguiente cliente en la fila: " + proximo.getNombre());

            // Atención formal del cliente
            Cliente atendido = banco.atenderCliente();
            System.out.println("Atendiendo a: " + atendido.getNombre());

            // Estado actual de la cola
            System.out.println("Clientes restantes en la cola: " + banco.obtenerCantidadClientes());
            System.out.println();
        }

        System.out.println("Fin de la jornada: Todos los clientes han sido atendidos correctamente.");
    }
}