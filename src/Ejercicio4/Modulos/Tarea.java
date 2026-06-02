package Ejercicio4.Modulos;

public class Tarea {
    private String descripcion;
    private boolean urgente;

    // Constructor vacío
    public Tarea() {
    }

    // Constructor con parámetros
    public Tarea(String descripcion, boolean urgente) {
        this.descripcion = descripcion;
        this.urgente = urgente;
    }

    // Getters y Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    // Método auxiliar para obtener la prioridad en texto
    public String getTipo() {
        return urgente ? "Urgente" : "Normal";
    }
}