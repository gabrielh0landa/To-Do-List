package aplicacao.todolist.apresentacao;

import aplicacao.todolist.logicadenegocios.FuncoesTarefa;
import aplicacao.todolist.model.NivelPrioridade;
import aplicacao.todolist.model.Status;
import aplicacao.todolist.model.Tarefa;

import java.time.LocalDateTime;

public class ToDoList {

    public static void main(String[] args) {
        FuncoesTarefa servicoDeTarefas = new FuncoesTarefa();

        LocalDateTime dataDeHoje = LocalDateTime.now();
        Tarefa tarefa1 = new Tarefa("Estudar Java", "Aprender sobre Collections", dataDeHoje, "Estudo", NivelPrioridade.Alta, Status.ToDo);
        Tarefa tarefa2 = new Tarefa("Comprar Pão", "Comprar pão francês", dataDeHoje, "Pessoal", NivelPrioridade.Baixa, Status.ToDo);

        System.out.println("--- Adicionando Tarefas ---");
        servicoDeTarefas.criarTarefa(tarefa1);
        servicoDeTarefas.criarTarefa(tarefa2);

        System.out.println("\n--- Visualizando Tarefa 'Estudar Java' ---");
        servicoDeTarefas.visualizarTarefa("Estudar Java");

        System.out.println("\n--- Visualizando Tarefa 'Comprar Pão' ---");
        servicoDeTarefas.visualizarTarefa("Comprar Pão");


        System.out.println("\n--- Deletando Tarefa 'Compra  dois Pão' ---");
        servicoDeTarefas.deletarTarefa("Comprar Pão");


        System.out.println("\n--- Tentando visualizar Tarefa 'Comprar Pão' ---");
        servicoDeTarefas.visualizarTarefa("Comprar Pão");
    }
}