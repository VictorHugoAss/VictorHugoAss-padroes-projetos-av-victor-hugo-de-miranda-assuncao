
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class Auditoria {
    private static final Auditoria INSTANCIA = new Auditoria();
    private final List<String> registros = new ArrayList<>();

    private Auditoria() {
    }

    public static Auditoria getInstance() { return INSTANCIA; }

    public synchronized void registrar(String ambiente, String provedor, String resultado, String motivo) {
        registros.add(LocalDateTime.now() + " | " + ambiente + " | " + provedor
                + " | " + resultado + " | " + motivo);
    }

    public synchronized List<String> getRegistros() {
        return new ArrayList<>(registros);
    }

    public void imprimirHistorico() {
        System.out.println("\nHISTÓRICO DE PROVISIONAMENTOS");
        for (String registro : getRegistros()) {
            System.out.println(registro);
        }
    }
}
