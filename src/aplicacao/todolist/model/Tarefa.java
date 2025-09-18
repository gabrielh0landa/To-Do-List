package aplicacao.todolist.model;
import java.time.LocalDateTime;

public class Tarefa implements Comparable<Tarefa>{

    private String nome;
    private String descricao;
    private LocalDateTime dataDeTermino;
    private String categoria;
    private NivelPrioridade nivelPrioridade;
    private Status status;

    public Tarefa(String nome, String descricao, LocalDateTime dataDeTermino, String categoria, NivelPrioridade nivelPrioridade, Status status) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataDeTermino = dataDeTermino;
        this.categoria = categoria;
        this.nivelPrioridade = nivelPrioridade;
        this.status = status;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataDeTermino() {
        return dataDeTermino;
    }

    public void setDataDeTermino(LocalDateTime dataDeTermino) {
        this.dataDeTermino = dataDeTermino;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public NivelPrioridade getNivelPrioridade() {
        return nivelPrioridade;
    }

    public void setNivelPrioridade(NivelPrioridade nivelPrioridade) {
        this.nivelPrioridade = nivelPrioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int compareTo(Tarefa outra) {
        return outra.getNivelPrioridade().compareTo(this.getNivelPrioridade());
    }
}











