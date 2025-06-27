package observer;

import models.Tarea;

import java.time.LocalDate;
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

    public List<Tarea> obtenerRecordatorios() {
        List<Tarea> recordatorios = new ArrayList<>();
        LocalDate hoy = LocalDate.now();

        for (Tarea t : tareas) {
            if ("pendiente".equalsIgnoreCase(t.getEstado())) {
                if (!t.getFechaLimite().isBefore(hoy) && !t.getFechaLimite().isAfter(hoy.plusDays(1))) {
                    recordatorios.add(t);
                }
            }
        }
        return recordatorios;
    }
}