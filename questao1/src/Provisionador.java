
import java.util.ArrayList;
import java.util.List;

public class Provisionador {
    private static final int HORAS_MENSAIS = 730;
    private final FabricaRecursos fabrica;

    public Provisionador(FabricaRecursos fabrica) {
        this.fabrica = fabrica;
    }

    public Ambiente provisionar(String nome, int quantidadeMaquinas, int gb) {
        Configuracao configuracao = Configuracao.getInstance();
        Auditoria auditoria = Auditoria.getInstance();
        String provedor = fabrica.getNomeProvedor();
        double custo = quantidadeMaquinas * fabrica.getCustoHoraMaquina() * HORAS_MENSAIS
                + gb * fabrica.getCustoGb() + fabrica.getCustoFila();
        // O custo por GB usa três casas decimais.
        custo = Math.round(custo * 1000) / 1000.0;
        if (custo > configuracao.getOrcamentoMensal()) {
            auditoria.registrar(nome, provedor, "RECUSADO", "Custo " + custo
                    + " acima do orçamento " + configuracao.getOrcamentoMensal());
            System.out.println(nome + ": RECUSADO - orçamento excedido.");
            return null;
        }

        List<MaquinaVirtual> maquinas = new ArrayList<>();
        for (int i = 0; i < quantidadeMaquinas; i++) {
            maquinas.add(fabrica.criarMaquina());
        }
        Armazenamento armazenamento = fabrica.criarArmazenamento();
        Fila fila = fabrica.criarFila();
        try {
            Ambiente ambiente = new Ambiente(nome, provedor, configuracao.getRegiao(),
                    maquinas, armazenamento, fila, custo);
            auditoria.registrar(nome, provedor, "ACEITO", "Recursos criados");
            ambiente.imprimirResumo();
            return ambiente;
        } catch (IllegalArgumentException e) {
            auditoria.registrar(nome, provedor, "RECUSADO", e.getMessage());
            System.out.println(nome + ": RECUSADO - " + e.getMessage());
            return null;
        }
    }
}
