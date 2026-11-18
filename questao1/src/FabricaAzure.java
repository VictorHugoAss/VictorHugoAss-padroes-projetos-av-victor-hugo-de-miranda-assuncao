
public class FabricaAzure implements FabricaRecursos {
    private static long maquinas;
    private static long armazenamentos;
    private static long filas;

    @Override
    public String getNomeProvedor() { return "Azure"; }

    @Override
    public double getCustoHoraMaquina() { return MaquinaAzure.CUSTO; }

    @Override
    public double getCustoGb() { return ArmazenamentoAzure.CUSTO; }

    @Override
    public double getCustoFila() { return FilaAzure.CUSTO; }

    @Override
    public MaquinaVirtual criarMaquina() {
        return new MaquinaAzure(proximaMaquina());
    }

    @Override
    public Armazenamento criarArmazenamento() {
        return new ArmazenamentoAzure(proximoArmazenamento());
    }

    @Override
    public Fila criarFila() {
        return new FilaAzure(proximaFila());
    }

    private static synchronized long proximaMaquina() { return ++maquinas; }
    private static synchronized long proximoArmazenamento() { return ++armazenamentos; }
    private static synchronized long proximaFila() { return ++filas; }
}
