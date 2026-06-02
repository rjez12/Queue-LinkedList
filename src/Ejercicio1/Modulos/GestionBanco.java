package Ejercicio1.Modulos;
import java.util.LinkedList;
import java.util.Queue;

public class GestionBanco {
    private Queue<Cliente> colaBanco;

    // Constructor que inicializa la estructura de datos
    public GestionBanco() {
        this.colaBanco = new LinkedList<>();
    }

    // Método para registrar la llegada de un cliente
    public void registrarCliente(Cliente cliente) {
        colaBanco.offer(cliente);
    }

    // Método para obtener el tamaño actual de la fila
    public int obtenerCantidadClientes() {
        return colaBanco.size();
    }

    // Método para verificar si la fila está vacía
    public boolean tieneClientesEnEspera() {
        return !colaBanco.isEmpty();
    }

    // Método para observar al siguiente cliente sin removerlo
    public Cliente verSiguienteCliente() {
        return colaBanco.peek();
    }

    // Método para atender y remover al cliente al frente de la cola
    public Cliente atenderCliente() {
        return colaBanco.poll();
    }
}