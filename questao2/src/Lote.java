import java.util.ArrayList;
import java.util.List;
public class Lote {
    private final String nome;
    private final String categoria;
    private final double precoInicial;
    private final double precoReserva;
    private final List<Interessado> interessados = new ArrayList<>();
    private final List<Lance> lances = new ArrayList<>();
    private RegraComissao regraComissao;
    private boolean encerrado;
    private boolean vendido;
    private double comissao;

    public Lote(String nome, String categoria, double precoInicial, double precoReserva, RegraComissao regraComissao) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.regraComissao = regraComissao;
    }

    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public boolean isVendido() { return vendido; }
    public List<Lance> getLances() { return new ArrayList<>(lances); }

    public double getLanceAtual() {
        if (lances.isEmpty()) {
            return precoInicial;
        }
        return lances.get(lances.size() - 1).getValor();
    }

    public void acompanhar(Interessado interessado) {
        if (!interessados.contains(interessado)) {
            interessados.add(interessado);
        }
    }

    public void deixarDeAcompanhar(Interessado interessado) {
        interessados.remove(interessado);
    }

    public boolean darLance(Licitante participante, double valor) {
        if (encerrado) {
            System.out.println("Lance recusado em " + nome + ": lote encerrado.");
            return false;
        }
        long lanceAtualCentavos = Math.round(getLanceAtual() * 100);
        // Arredonda o aumento de 5% para o próximo centavo.
        long minimoCentavos = (lanceAtualCentavos * 105 + 99) / 100;
        long valorCentavos = Math.round(valor * 100);
        if (valorCentavos < minimoCentavos) {
            System.out.printf("Lance recusado em %s: informe ao menos R$ %.2f.%n",
                    nome, minimoCentavos / 100.0);
            return false;
        }
        Lance lance = new Lance(participante, valorCentavos / 100.0);
        lances.add(lance);
        System.out.printf("Lance aceito: %s em %s por R$ %.2f%n",
                participante.getNome(), nome, lance.getValor());
        for (Interessado interessado : interessados) {
            if (interessado != participante) {
                interessado.atualizar(nome, lance, lances.size());
            }
        }
        return true;
    }

    public void alterarRegraComissao(RegraComissao regra) {
        if (encerrado) {
            throw new IllegalStateException("O lote já foi encerrado.");
        }
        regraComissao = regra;
    }

    public void encerrar() {
        if (encerrado) {
            return;
        }
        vendido = !lances.isEmpty() && getLanceAtual() >= precoReserva;
        if (vendido) {
            comissao = regraComissao.calcular(getLanceAtual());
        }
        encerrado = true;
        System.out.println(nome + (vendido ? ": VENDIDO" : ": NÃO VENDIDO"));
    }

    public double getComissao() {
        return comissao;
    }

    public void imprimirAcertoVendedor() {
        if (!vendido) {
            System.out.println(nome + ": sem venda e sem comissão.");
            return;
        }
        System.out.printf("\nACERTO DO VENDEDOR - %s\nValor de venda: R$ %.2f"
                + "\nComissão: R$ %.2f\nValor líquido: R$ %.2f%n",
                nome, getLanceAtual(), comissao, getLanceAtual() - comissao);
    }
}
