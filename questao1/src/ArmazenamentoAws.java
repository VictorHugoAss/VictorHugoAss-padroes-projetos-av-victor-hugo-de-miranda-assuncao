public class ArmazenamentoAws implements Armazenamento {
    public static final double CUSTO = 0.023;
    private final String id;

    ArmazenamentoAws(long numero) {
        id = "s3://" + numero;
    }

    @Override
    public String getId() { return id; }

    @Override
    public String getProvedor() { return "Aws"; }

    @Override
    public double getCustoGb() { return CUSTO; }
}
