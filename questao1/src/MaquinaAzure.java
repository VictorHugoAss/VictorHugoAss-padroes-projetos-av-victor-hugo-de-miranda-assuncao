
public class MaquinaAzure implements MaquinaVirtual {
    public static final double CUSTO = 0.12;
    private final String id;

    MaquinaAzure(long numero) {
        id = "vm-" + numero;
    }

    @Override
    public String getId() { return id; }

    @Override
    public String getProvedor() { return "Azure"; }

    @Override
    public double getCustoHora() { return CUSTO; }
}
