package aplicacao.todolist.model;

public enum NivelPrioridade {
    MINIMA(1), 
    BAIXA(2), 
    MEDIA(3), 
    ALTA(4), 
    MAXIMA(5);

    private final int valor;

    NivelPrioridade(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}