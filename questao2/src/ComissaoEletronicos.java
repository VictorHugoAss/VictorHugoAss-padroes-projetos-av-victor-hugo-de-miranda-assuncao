public class ComissaoEletronicos implements RegraComissao {
    @Override
    public double calcular(double valorVenda) {
        double comissao = Math.max(valorVenda * 0.12, 50.00);
        return Math.round(comissao * 100) / 100.0;
    }
}
