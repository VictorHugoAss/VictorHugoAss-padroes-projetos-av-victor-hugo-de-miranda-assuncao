public class Venda implements Fatura {
    private final String lote;
    private final double valorVenda;

    public Venda(Lote lote) {
        if (!lote.isVendido()) {
            throw new IllegalArgumentException("Somente lotes vendidos geram faturas.");
        }
        this.lote = lote.getNome();
        valorVenda = lote.getLanceAtual();
    }

    @Override
    public String getDescricao() {
        return String.format("Lote: %s\nValor de venda: R$ %.2f", lote, valorVenda);
    }

    @Override
    public double getValorVenda() { return valorVenda; }

    @Override
    public double getTotal() { return valorVenda; }
}
