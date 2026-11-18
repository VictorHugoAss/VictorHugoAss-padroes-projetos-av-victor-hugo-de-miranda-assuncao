public class ComissaoVeiculos implements RegraComissao {
    @Override
    public double calcular(double valorVenda) {
        double comissao = Math.min(valorVenda * 0.08, 5000.00);
        return Math.round(comissao * 100) / 100.0;
    }
}
