public class ComissaoArte implements RegraComissao {
    @Override
    public double calcular(double valorVenda) {
        double comissao = valorVenda * 0.20;
        return Math.round(comissao * 100) / 100.0;
    }
}
