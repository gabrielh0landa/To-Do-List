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
        Tarefa tarefa1 = new Tarefa("Estudar Java", "Aprender sobre Collections", dataDeHoje, "Estudo", NivelPrioridade.MINIMA, Status.ToDo);
        Tarefa tarefa2 = new Tarefa("Comprar Pão", "Comprar pão francês", dataDeHoje, "Pessoal", NivelPrioridade.BAIXA, Status.ToDo);
        Tarefa tarefa3 = new Tarefa("Fazer Almoço", "Fazer feijão", dataDeHoje, "Pessoal", NivelPrioridade.MEDIA, Status.Done);
        Tarefa tarefa4 = new Tarefa("Dar banho no cachorro", "Usar shampo neutro", dataDeHoje, "Pessoal", NivelPrioridade.ALTA, Status.ToDo);

        System.out.println("--- Adicionando Tarefas ---");
        servicoDeTarefas.criarTarefa(tarefa1);
        servicoDeTarefas.criarTarefa(tarefa2);
        servicoDeTarefas.criarTarefa(tarefa3);
        servicoDeTarefas.criarTarefa(tarefa4);


        System.out.println("\n--- Visualizando Tarefa 'Estudar Java' ---");
        servicoDeTarefas.visualizarTarefa("Estudar Java");

        System.out.println("\n--- Visualizando Tarefa 'Comprar Pão' ---");
        servicoDeTarefas.visualizarTarefa("Comprar Pão");

        System.out.println("\n--- Deletando Tarefa 'Compra dois Pão' ---");
        servicoDeTarefas.deletarTarefa("Comprar dois Pão");
        
        System.out.println("\n--- Tentando visualizar Lista de Tarefas ---");
        servicoDeTarefas.visualizarListaTarefa();
        
        System.out.println("\n--- Visualizando tarefas por categoria ---");
        servicoDeTarefas.visualizarPorCategoria("Estudo");
        
        System.out.println("\n--- Visualizando tarefas por status ---");
        servicoDeTarefas.visualizarPorStatus(Status.Done);

        
    }
}