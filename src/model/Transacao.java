package app.model;

public abstract class Transacao {
    private final String descricao;
    private final double valor;

    public Transacao(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() { return descricao; }
    public double getValor() { return valor; }

    public abstract String getTipo();
}
