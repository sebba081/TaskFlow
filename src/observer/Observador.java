package observer;

import models.Tarea;

public interface Observador {
    void notificar(Tarea tarea);
}