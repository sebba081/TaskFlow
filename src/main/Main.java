package main;

import factory.TareaFactory;
import models.Tarea;
import decorator.RecordatorioDecorator;
import observer.ConsolaObservador;
import observer.SistemaTareas;
import strategy.OrdenarPorPrioridad;
import strategy.Ordenador;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static SistemaTareas sistema = new SistemaTareas();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        sistema.agregarObservador(new ConsolaObservador());

        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarTarea();
                    break;
                case 2:
                    mostrarTareas();
                    break;
                case 3:
                    ordenarTareas();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void mostrarMenu() {
        // limpiar la consola
        System.out.print("\033[H\033[2J");
        System.out.flush();

        mostrarRecordatorios();

        System.out.println("\n--- Menú ---");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Mostrar tareas");
        System.out.println("3. Ordenar tareas");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarRecordatorios() {
        List<Tarea> recordatorios = sistema.obtenerRecordatorios();
        if (!recordatorios.isEmpty()) {
            System.out.println("Recordatorios (tareas próximas):");
            for (Tarea t : recordatorios) {
                System.out.println(" - " + t.getDescripcion() + " (vence el " + t.getFechaLimite() + ")");
            }
            System.out.println();
        }
    }

    private static void agregarTarea() {
        System.out.println("\n--- Agregar Nueva Tarea ---");

        // Descripción
        System.out.print("Ingrese la descripción de la tarea: ");
        String descripcion = scanner.nextLine();

        // Prioridad
        String prioridad;
        do {
            System.out.print("Ingrese la prioridad (baja/normal/alta/urgente): ");
            prioridad = scanner.nextLine().toLowerCase();
        } while (!prioridad.matches("baja|normal|alta|urgente"));

        // Fecha límite
        LocalDate fechaLimite;
        while (true) {
            try {
                System.out.print("Ingrese la fecha límite (formato YYYY-MM-DD): ");
                String fechaStr = scanner.nextLine();
                fechaLimite = LocalDate.parse(fechaStr);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Por favor, use el formato YYYY-MM-DD.");
            }
        }

        // Estado
        String estado = "pendiente"; // Por defecto, una nueva tarea está pendiente

        // Crear la tarea usando el Factory
        Tarea tarea = TareaFactory.crearTarea(prioridad, descripcion, fechaLimite, estado);
        sistema.agregarTarea(tarea);

        System.out.println("Tarea agregada con éxito.");
        esperarEnter();
    }

    private static void mostrarTareas() {
        List<Tarea> tareas = sistema.getTareas();
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas en el sistema.");
        } else {
            for (Tarea t : tareas) {
                System.out.println(t); // Esto usará el método toString() de Tarea
            }
        }
        esperarEnter();
    }

    private static void ordenarTareas() {
        Ordenador ordenador = new Ordenador();
        ordenador.setEstrategia(new OrdenarPorPrioridad());
        List<Tarea> ordenadas = ordenador.ordenar(new ArrayList<>(sistema.getTareas()));

        System.out.println("\nTareas ordenadas por prioridad:");
        for (Tarea t : ordenadas) {
            System.out.println(t.getDescripcion() + " - Prioridad: " + t.getPrioridad() +
                    " - Fecha límite: " + t.getFechaLimite() +
                    " - Estado: " + t.getEstado());
        }
        esperarEnter();
    }

    public static void esperarEnter() {
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
}