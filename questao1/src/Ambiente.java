
import java.util.ArrayList;
import java.util.List;
public class Ambiente {
    private final String nome;
    private final String provedor;
    private final String regiao;
    private final List<MaquinaVirtual> maquinas;
    private final Armazenamento armazenamento;
    private final Fila fila;
    private final double custoMensal;

    Ambiente(String nome, String provedor, String regiao, List<MaquinaVirtual> maquinas, Armazenamento armazenamento, Fila fila, double custoMensal) {
        if (!provedor.equals(armazenamento.getProvedor()) || !provedor.equals(fila.getProvedor())) {
            throw new IllegalArgumentException("Os recursos precisam ser do mesmo provedor.");
        }
        for (MaquinaVirtual maquina : maquinas) {
            if (!provedor.equals(maquina.getProvedor())) {
                throw new IllegalArgumentException("Os recursos precisam ser do mesmo provedor.");
            }
        }
        this.nome = nome;
        this.provedor = provedor;
        this.regiao = regiao;
        this.maquinas = new ArrayList<>(maquinas);
        this.armazenamento = armazenamento;
        this.fila = fila;
        this.custoMensal = custoMensal;
    }

    public List<MaquinaVirtual> getMaquinas() { return new ArrayList<>(maquinas); }
    public Armazenamento getArmazenamento() { return armazenamento; }
    public Fila getFila() { return fila; }
    public double getCustoMensal() { return custoMensal; }

    public void imprimirResumo() {
        String resumo = "\nAmbiente: " + nome + "\nProvedor: " + provedor + "\nRegião: " + regiao;
        for (MaquinaVirtual maquina : maquinas) {
            resumo += "\nMáquina: " + maquina.getId();
        }
        resumo += "\nArmazenamento: " + armazenamento.getId() + "\nFila: " + fila.getId()
                + String.format("\nCusto mensal: R$ %.2f\n", custoMensal);
        System.out.print(resumo);
    }
}
