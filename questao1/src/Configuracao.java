
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class Configuracao {
    private static final Configuracao INSTANCIA = new Configuracao();
    private final String regiao;
    private final double orcamentoMensal;

    private Configuracao() {
        File pasta = new File(System.getProperty("user.dir"));
        File caminho = new File(pasta, "config.properties");
        while (!caminho.isFile() && pasta.getParentFile() != null) {
            pasta = pasta.getParentFile();
            caminho = new File(pasta, "config.properties");
        }

        Properties propriedades = new Properties();
        try (FileInputStream arquivo = new FileInputStream(caminho)) {
            propriedades.load(arquivo);
        } catch (IOException e) {
            throw new IllegalStateException("Não foi possível localizar ou ler config.properties a partir de " + System.getProperty("user.dir"), e);
        }
        regiao = propriedades.getProperty("regiao");
        orcamentoMensal = Double.parseDouble(propriedades.getProperty("orcamento.mensal"));
    }

    public static Configuracao getInstance() { return INSTANCIA; }
    public String getRegiao() { return regiao; }
    public double getOrcamentoMensal() { return orcamentoMensal; }
}
