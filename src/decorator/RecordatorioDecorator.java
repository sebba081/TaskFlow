package decorator;

public class RecordatorioDecorator extends TareaDecorator {
    public RecordatorioDecorator(models.Tarea tarea) {
        super(tarea);
        System.out.println("[Recordatorio] No olvides: " + tarea.getDescripcion());
    }
}