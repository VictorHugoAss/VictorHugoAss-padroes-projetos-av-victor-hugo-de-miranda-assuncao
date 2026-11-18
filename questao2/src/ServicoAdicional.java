public abstract class ServicoAdicional implements Fatura {
    private final Fatura fatura;

    protected ServicoAdicional(Fatura fatura) {
        this.fatura = fatura;
    }

    protected abstract String getNomeServico();
    protected abstract double getCustoServico();

    @Override
    public double getValorVenda() { return fatura.getValorVenda(); }

    @Override
    public String getDescricao() {
        return fatura.getDescricao()
                + String.format("\n%s: R$ %.2f", getNomeServico(), getCustoServico());
    }

    @Override
    public double getTotal() {
        return Math.round((fatura.getTotal() + getCustoServico()) * 100) / 100.0;
    }
}
