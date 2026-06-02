package Ejercicio4.Modulos;

import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayList;
import java.util.List;

public class GestionTarea {
    private Deque<Tarea> colaTareas;

    // Constructor que inicializa la estructura requerida
    public GestionTarea() {
        this.colaTareas = new LinkedList<>();
    }

    // MÉTODO DE PRE-CARGA: Guarda los ejemplos exactos de la guía
    public void cargarTareasPredeterminadas() {
        this.registrarTarea(new Tarea("Revisar correos", false));
        this.registrarTarea(new Tarea("Actualizar reporte", false));
        this.registrarTarea(new Tarea("Reiniciar servidor", true));
        this.registrarTarea(new Tarea("Resolver caída del sistema", true));
    }

    // Registrar tareas aplicando prioridades manuales
    public void registrarTarea(Tarea tarea) {
        if (tarea.isUrgente()) {
            // Tareas urgentes se posicionan al inicio (Frente)
            colaTareas.offerFirst(tarea);
        } else {
            // Tareas normales se posicionan al final (Cola)
            colaTareas.offerLast(tarea);
        }
    }

    // Procesar y remover la siguiente tarea en orden de ejecución
    public Tarea procesarSiguienteTarea() {
        return colaTareas.pollFirst();
    }

    // Observar la próxima tarea sin removerla de la lista
    public Tarea verProximaTarea() {
        return colaTareas.peekFirst();
    }

    // Verificar si quedan tareas en la estructura
    public boolean tieneTareasPendientes() {
        return !colaTareas.isEmpty();
    }

    // Cantidad actual de tareas en espera
    public int obtenerCantidadTareas() {
        return colaTareas.size();
    }

    // Generar lista de cadenas formateadas para proteger el encapsulamiento
    public List<String> obtenerOrdenEjecucionFormateado() {
        List<String> listaFormateada = new ArrayList<>();
        int posicion = 1;

        for (Tarea t : colaTareas) {
            listaFormateada.add(posicion + ". [" + t.getTipo() + "] " + t.getDescripcion());
            posicion++;
        }

        return listaFormateada;
    }
}