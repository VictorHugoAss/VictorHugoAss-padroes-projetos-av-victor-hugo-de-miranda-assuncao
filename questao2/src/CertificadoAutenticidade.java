public class CertificadoAutenticidade extends ServicoAdicional {
    public CertificadoAutenticidade(Fatura fatura) { super(fatura); }

    @Override
    protected String getNomeServico() { return "Certificado de autenticidade"; }

    @Override
    protected double getCustoServico() { return 300.00; }
}
