package app.model;

public class Despesa extends Transacao {
    public Despesa(String descricao, double valor) {
        super(descricao, valor * -1);
    }

    @Override
    public String getTipo() {
        return "Despesa";
    }
}

