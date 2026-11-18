
public class FabricaAws implements FabricaRecursos {
    private static long maquinas;
    private static long armazenamentos;
    private static long filas;

    @Override
    public String getNomeProvedor() { return "Aws"; }

    @Override
    public double getCustoHoraMaquina() { return MaquinaAws.CUSTO; }

    @Override
    public double getCustoGb() { return ArmazenamentoAws.CUSTO; }

    @Override
    public double getCustoFila() { return FilaAws.CUSTO; }

    @Override
    public MaquinaVirtual criarMaquina() {
        return new MaquinaAws(proximaMaquina());
    }

    @Override
    public Armazenamento criarArmazenamento() {
        return new ArmazenamentoAws(proximoArmazenamento());
    }

    @Override
    public Fila criarFila() {
        return new FilaAws(proximaFila());
    }

    private static synchronized long proximaMaquina() { return ++maquinas; }
    private static synchronized long proximoArmazenamento() { return ++armazenamentos; }
    private static synchronized long proximaFila() { return ++filas; }
}
