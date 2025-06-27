package models;

import java.time.LocalDate;

public class TareaNormal {
    private String descripcion;
    private LocalDate fecha;

    public TareaNormal(String descripcion, LocalDate fecha) {
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getPrioridad() {
        return 1;
    }
}
