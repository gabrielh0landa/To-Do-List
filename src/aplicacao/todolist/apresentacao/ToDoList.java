package aplicacao.todolist.apresentacao;

import aplicacao.todolist.logicadenegocios.FuncoesTarefa;
import aplicacao.todolist.model.NivelPrioridade;
import aplicacao.todolist.model.Status;
import aplicacao.todolist.model.Tarefa;

import java.time.LocalDateTime;

public class ToDoList {

    public static void main(String[] args) {
        // 1. Crie uma instância da sua camada de lógica de negócio
        FuncoesTarefa servicoDeTarefas = new FuncoesTarefa();

        // 2. Crie uma nova tarefa
        LocalDateTime dataDeHoje = LocalDateTime.now();
        Tarefa tarefa1 = new Tarefa("Estudar Java", "Aprender sobre Collections", dataDeHoje, "Estudo", NivelPrioridade.Alta, Status.ToDo);
        Tarefa tarefa2 = new Tarefa("Comprar Pão", "Comprar pão francês", dataDeHoje, "Pessoal", NivelPrioridade.Baixa, Status.ToDo);

        // 3. Adicione as tarefas usando o método da sua classe de serviço
        System.out.println("--- Adicionando Tarefas ---");
        servicoDeTarefas.criarTarefa(tarefa1);
        servicoDeTarefas.criarTarefa(tarefa2);

        // 4. Visualize a tarefa para confirmar que ela foi adicionada
        System.out.println("\n--- Visualizando Tarefa 'Estudar Java' ---");
        servicoDeTarefas.visualizarTarefa("Estudar Java");

        System.out.println("\n--- Visualizando Tarefa 'Comprar Pão' ---");
        servicoDeTarefas.visualizarTarefa("Comprar Pão");


        // 5. Delete uma tarefa
        System.out.println("\n--- Deletando Tarefa 'Comprar Pão' ---");
        boolean deletou = servicoDeTarefas.deletarTarefa("Comprar Pão");

        if (deletou) {
            System.out.println("Tarefa 'Comprar Pão' deletada com sucesso.");
        } else {
            System.out.println("Tarefa não encontrada.");
        }

        // 6. Tente visualizar a tarefa deletada
        System.out.println("\n--- Tentando visualizar Tarefa 'Comprar Pão' ---");
        servicoDeTarefas.visualizarTarefa("Comprar Pão");
    }
}