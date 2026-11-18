public class Main {
    public static void main(String[] args) {
        Lote quadro = new Lote("Quadro Primavera", "Arte",
                1000.00, 1200.00, new ComissaoArte());
        Lote carro = new Lote("Carro antigo", "Veículos",
                20000.00, 30000.00, new ComissaoVeiculos());
        Participante victor = new Participante("Victor");
        Participante nicolly = new Participante("Nicolly");
        Participante hugo = new Participante("hugo");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        for (Lote lote : new Lote[] { quadro, carro }) {
            lote.acompanhar(victor);
            lote.acompanhar(nicolly);
            lote.acompanhar(hugo);
            lote.acompanhar(painel);
            lote.acompanhar(auditor);
        }
        quadro.darLance(victor, 1050.00);
        quadro.darLance(nicolly, 1100.00);
        quadro.darLance(hugo, 1200.00);
        quadro.deixarDeAcompanhar(victor);
        System.out.println("\nVictor deixou de acompanhar o quadro.");
        quadro.darLance(nicolly, 1260.00);
        carro.darLance(victor, 21000.00);
        carro.darLance(nicolly, 22050.00);

        System.out.println("\nCampanha: quadro usará a comissão de Eletrônicos.");
        quadro.alterarRegraComissao(new ComissaoEletronicos());
        quadro.encerrar();
        carro.encerrar();
        quadro.darLance(hugo, 1323.00);

        Fatura fatura = new Venda(quadro);
        fatura = new SeguroTransporte(fatura);
        fatura = new CertificadoAutenticidade(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EntregaExpressa(fatura);
        new ImpressoraFatura().imprimir(fatura);
        quadro.imprimirAcertoVendedor();
        carro.imprimirAcertoVendedor();
        System.out.println("\nLances aceitos registrados pelo auditor: " + auditor.getRegistros().size());
    }
}
