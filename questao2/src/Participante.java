public class Participante implements Licitante {
    private final String nome;

    public Participante(String nome) { this.nome = nome; }

    @Override
    public String getNome() { return nome; }

    @Override
    public void atualizar(String lote, Lance lance, int totalLances) {
        System.out.println(nome + " acompanha " + lote + ": novo lance de R$ " + lance.getValor());
    }
}
