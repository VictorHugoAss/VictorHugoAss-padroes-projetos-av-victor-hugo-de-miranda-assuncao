public class ComissaoImoveis implements RegraComissao {
    @Override
    public double calcular(double valorVenda) {
        double comissao = valorVenda * 0.03 + 1500.00;
        return Math.round(comissao * 100) / 100.0;
    }
}
