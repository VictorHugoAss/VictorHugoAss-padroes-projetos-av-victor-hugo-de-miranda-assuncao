public class EmbalagemEspecial extends ServicoAdicional {
    public EmbalagemEspecial(Fatura fatura) { super(fatura); }

    @Override
    protected String getNomeServico() { return "Embalagem especial"; }

    @Override
    protected double getCustoServico() { return 180.00; }
}
