package models;

import java.time.LocalDate;

public class Tarea {
    private String descripcion;
    private int prioridad;
    private LocalDate fechaLimite;
    private String estado;

    // Constructor
    public Tarea(String descripcion, String prioridadStr, LocalDate fechaLimite, String estado) {
        this.descripcion = descripcion;
        this.setPrioridad(prioridadStr);
        this.fechaLimite = fechaLimite;
        this.estado = estado;
    }

    // Getters
    public String getDescripcion() {
        return descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public String getEstado() {
        return estado;
    }

    // Setters
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrioridad(String prioridadStr) {
        switch (prioridadStr.toLowerCase()) {
            case "baja":
                this.prioridad = 1;
                break;
            case "normal":
                this.prioridad = 2;
                break;
            case "alta":
                this.prioridad = 3;
                break;
            case "urgente":
                this.prioridad = 4;
                break;
            default:
                this.prioridad = 0;
        }
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tarea: " + descripcion +
                " | Prioridad: " + prioridad +
                " | Fecha límite: " + fechaLimite +
                " | Estado: " + estado;
    }
}