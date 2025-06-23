package strategy;

import models.Tarea;

import java.util.List;

public interface EstrategiaOrdenamiento {
    List<Tarea> ordenar(List<Tarea> tareas);
}