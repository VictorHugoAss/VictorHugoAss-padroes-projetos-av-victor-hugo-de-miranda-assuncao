public class PainelLeiloeiro implements Interessado {
    @Override
    public void atualizar(String lote, Lance lance, int totalLances) {
        System.out.printf("Painel - %s | Maior lance: R$ %.2f | Total de lances: %d%n",
                lote, lance.getValor(), totalLances);
    }
}
