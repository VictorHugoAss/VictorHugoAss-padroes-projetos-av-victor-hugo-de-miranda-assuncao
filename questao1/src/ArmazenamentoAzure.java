
public class ArmazenamentoAzure implements Armazenamento {
    public static final double CUSTO = 0.02;
    private final String id;

    ArmazenamentoAzure(long numero) {
        id = "blob://" + numero;
    }

    @Override
    public String getId() { return id; }

    @Override
    public String getProvedor() { return "Azure"; }

    @Override
    public double getCustoGb() { return CUSTO; }
}
