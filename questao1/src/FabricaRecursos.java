
public interface FabricaRecursos {
    String getNomeProvedor();
    double getCustoHoraMaquina();
    double getCustoGb();
    double getCustoFila();
    MaquinaVirtual criarMaquina();
    Armazenamento criarArmazenamento();
    Fila criarFila();
}
