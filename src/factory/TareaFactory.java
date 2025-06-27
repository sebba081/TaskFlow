package factory;

import models.Tarea;
import java.time.LocalDate;

public class TareaFactory {
    public static Tarea crearTarea(String prioridad, String descripcion, LocalDate fechaLimite, String estado) {
        return new Tarea(descripcion, prioridad, fechaLimite, estado);
    }
}