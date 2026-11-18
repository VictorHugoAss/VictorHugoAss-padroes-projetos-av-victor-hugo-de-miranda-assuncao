public class SeguroTransporte extends ServicoAdicional {
    public SeguroTransporte(Fatura fatura) { super(fatura); }

    @Override
    protected String getNomeServico() { return "Seguro de transporte"; }

    @Override
    protected double getCustoServico() {
        return Math.round(getValorVenda() * 0.015 * 100) / 100.0;
    }
}
