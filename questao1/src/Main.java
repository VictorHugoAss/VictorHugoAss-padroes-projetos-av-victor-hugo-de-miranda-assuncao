public class Main {
    public static void main(String[] args) throws InterruptedException {
        Configuracao.getInstance();
        Provisionador aws = new Provisionador(new FabricaAws());
        Provisionador azure = new Provisionador(new FabricaAzure());
        Thread primeiro = new Thread(() -> aws.provisionar("Aplicacao", 2, 40));
        Thread segundo = new Thread(() -> azure.provisionar("Homologacao", 3, 100));
        primeiro.start();
        segundo.start();
        primeiro.join();
        segundo.join();

        aws.provisionar("Monitoramento", 1, 20);
        aws.provisionar("Acima-do-orcamento", 10, 500);
        Auditoria.getInstance().imprimirHistorico();
    }
}
