
public class FilaAzure implements Fila {
    public static final double CUSTO = 0.50;
    private final String id;

    FilaAzure(long numero) {
        id = "sb-" + numero;
    }

    @Override
    public String getId() { return id; }

    @Override
    public String getProvedor() { return "Azure"; }

    @Override
    public double getCustoMensal() { return CUSTO; }
}
