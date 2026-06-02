package Ejercicio3.Modulos;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class GestionHospital {
    private PriorityQueue<Paciente> colaPacientes;

    // Constructor que inicializa la estructura de datos
    public GestionHospital() {
        this.colaPacientes = new PriorityQueue<>();
    }

    // NUEVO MÉTODO: La pre-carga ahora se procesa desde el backend
    public void cargarPacientesPredeterminados() {
        this.registrarPaciente(new Paciente("Juan Pérez", 3));
        this.registrarPaciente(new Paciente("María López", 1));
        this.registrarPaciente(new Paciente("Carlos Gómez", 2));
        this.registrarPaciente(new Paciente("Ana Martínez", 1));
        this.registrarPaciente(new Paciente("Luis Rodríguez", 3));
        this.registrarPaciente(new Paciente("Sofía Hernández", 2));
    }

    // Registrar un nuevo paciente en la cola
    public void registrarPaciente(Paciente paciente) {
        colaPacientes.offer(paciente);
    }

    // Atender y remover al paciente con mayor prioridad
    public Paciente atenderPaciente() {
        return colaPacientes.poll();
    }

    // Observar al siguiente paciente sin modificar la cola
    public Paciente verSiguientePaciente() {
        return colaPacientes.peek();
    }

    // Comprobar si hay elementos en la estructura
    public boolean tienePacientes() {
        return !colaPacientes.isEmpty();
    }

    // Obtener la cantidad de elementos en la estructura
    public int obtenerCantidadPacientes() {
        return colaPacientes.size();
    }

    // Genera la lista formateada para la interfaz de consola
    public List<String> obtenerListaEsperaFormateada() {
        List<String> listaFormateada = new ArrayList<>();
        PriorityQueue<Paciente> copiaTemporal = new PriorityQueue<>(this.colaPacientes);
        int posicion = 1;

        while (!copiaTemporal.isEmpty()) {
            Paciente p = copiaTemporal.poll();
            listaFormateada.add(posicion + ". " + p.getNombre() + " -> " + p.getTipoPrioridad());
            posicion++;
        }

        return listaFormateada;
    }
}