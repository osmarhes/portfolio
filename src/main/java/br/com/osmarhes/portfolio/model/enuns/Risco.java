package br.com.osmarhes.portfolio.model.enuns;

public enum Risco {
    BAIXO("Baixo risco"),
    MEDIO("Médio risco"),
    ALTO("Alto risco");

    private final String descricao;

    Risco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
