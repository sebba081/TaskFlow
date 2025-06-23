package decorator;

import models.Tarea;

import java.time.LocalDate;

public abstract class TareaDecorator {
    protected Tarea tarea;

    public TareaDecorator(Tarea tarea) {
        this.tarea = tarea;
    }

    public String getDescripcion() {
        return tarea.getDescripcion();
    }

    public LocalDate getFecha() {
        return tarea.getFecha();
    }

    public int getPrioridad() {
        return tarea.getPrioridad();
    }
}