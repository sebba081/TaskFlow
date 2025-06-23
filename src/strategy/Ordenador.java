package strategy;

import models.Tarea;

import java.util.List;

public class Ordenador {
    private EstrategiaOrdenamiento estrategia;

    public void setEstrategia(EstrategiaOrdenamiento estrategia) {
        this.estrategia = estrategia;
    }

    public List<Tarea> ordenar(List<Tarea> tareas) {
        return estrategia.ordenar(tareas);
    }
}