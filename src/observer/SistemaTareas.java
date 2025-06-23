package observer;

import models.Tarea;

import java.util.ArrayList;
import java.util.List;

public class SistemaTareas {
    private final List<Tarea> tareas = new ArrayList<>();
    private final List<Observador> observadores = new ArrayList<>();

    public void agregarObservador(Observador obs) {
        observadores.add(obs);
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
        for (Observador obs : observadores) {
            obs.notificar(tarea);
        }
    }

    public List<Tarea> getTareas() {
        return tareas;
    }
}