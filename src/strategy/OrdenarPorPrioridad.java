package strategy;

import models.Tarea;

import java.util.Comparator;
import java.util.List;

public class OrdenarPorPrioridad implements EstrategiaOrdenamiento {
    public List<Tarea> ordenar(List<Tarea> tareas) {
        tareas.sort(Comparator.comparingInt(Tarea::getPrioridad).reversed());
        return tareas;
    }
}