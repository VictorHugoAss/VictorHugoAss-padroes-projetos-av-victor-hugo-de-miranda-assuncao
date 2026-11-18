import java.time.LocalDateTime;

public class Lance {
    private final Licitante participante;
    private final double valor;
    private final LocalDateTime dataHora;

    public Lance(Licitante participante, double valor) {
        this.participante = participante;
        this.valor = valor;
        dataHora = LocalDateTime.now();
    }

    public Licitante getParticipante() { return participante; }
    public double getValor() { return valor; }
    public LocalDateTime getDataHora() { return dataHora; }
}
