public class EntregaExpressa extends ServicoAdicional {
    public EntregaExpressa(Fatura fatura) { super(fatura); }

    @Override
    protected String getNomeServico() { return "Entrega expressa"; }

    @Override
    protected double getCustoServico() { return 450.00; }
}
