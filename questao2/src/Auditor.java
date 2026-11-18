import java.util.ArrayList;
import java.util.List;

public class Auditor implements Interessado {
    private final List<String> registros = new ArrayList<>();

    @Override
    public void atualizar(String lote, Lance lance, int totalLances) {
        String registro = lance.getDataHora() + " | " + lote + " | "
                + lance.getParticipante().getNome() + " | R$ " + lance.getValor();
        registros.add(registro);
        System.out.println("Auditor: " + registro);
    }

    public List<String> getRegistros() { return new ArrayList<>(registros); }
}
