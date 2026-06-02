package Ejercicio2.Modulos;

import java.util.ArrayDeque;
import java.util.Deque;

public class NavegadorWeb {
    private Deque<Pagina> historialAtras;
    private Deque<Pagina> historialAdelante;
    private Pagina paginaActual;

    public NavegadorWeb() {
        this.historialAtras = new ArrayDeque<>();
        this.historialAdelante = new ArrayDeque<>();
        this.paginaActual = null;
    }

    // Procesa la visita y actualiza los deques internamente
    public void visitarPagina(Pagina nuevaPagina) {
        if (paginaActual != null) {
            historialAtras.addFirst(paginaActual);
        }
        paginaActual = nuevaPagina;
        historialAdelante.clear();
    }

    // Lógica para retroceder en el historial
    public boolean retroceder() {
        if (historialAtras.isEmpty()) {
            return false;
        }
        historialAdelante.addFirst(paginaActual);
        paginaActual = historialAtras.removeFirst();
        return true;
    }

    // Lógica para avanzar en el historial
    public boolean avanzar() {
        if (historialAdelante.isEmpty()) {
            return false;
        }
        historialAtras.addFirst(paginaActual);
        paginaActual = historialAdelante.removeFirst();
        return true;
    }

    // Getters para que el Main consulte el estado actual sin modificar el backend
    public String getUrlActual() {
        return (paginaActual != null) ? paginaActual.getUrl() : "Ninguna (Historial vacío)";
    }

    public Deque<Pagina> getHistorialAtras() {
        return historialAtras;
    }

    public Deque<Pagina> getHistorialAdelante() {
        return historialAdelante;
    }
}