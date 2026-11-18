
public class MaquinaAws implements MaquinaVirtual {
    public static final double CUSTO = 0.10;
    private final String id;

    MaquinaAws(long numero) {
        id = "i-" + numero;
    }

    @Override
    public String getId() { return id; }

    @Override
    public String getProvedor() { return "Aws"; }

    @Override
    public double getCustoHora() { return CUSTO; }
}
