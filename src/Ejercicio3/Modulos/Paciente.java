package Ejercicio3.Modulos;

public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private int prioridad;

    public Paciente() {
    }

    public Paciente(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getTipoPrioridad() {
        switch (this.prioridad) {
            case 1: return "Emergencia";
            case 2: return "Urgente";
            case 3: return "Consulta General";
            default: return "Desconocida";
        }
    }

    @Override
    public int compareTo(Paciente otroPaciente) {
        return Integer.compare(this.prioridad, otroPaciente.prioridad);
    }
}