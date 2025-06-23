package observer;

import models.Tarea;

public class ConsolaObservador implements Observador {
    public void notificar(Tarea tarea) {
        System.out.println("[Notificación] Se ha agregado una nueva tarea: " + tarea.getDescripcion());
    }
}