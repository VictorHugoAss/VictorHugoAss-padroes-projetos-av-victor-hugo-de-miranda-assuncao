
public class FilaAws implements Fila {
    public static final double CUSTO = 0.40;
    private final String id;

    FilaAws(long numero) {
        id = "sqs-" + numero;
    }

    @Override
    public String getId() { return id; }

    @Override
    public String getProvedor() { return "Aws"; }

    @Override
    public double getCustoMensal() { return CUSTO; }
}
