package aplicacao.todolist.apresentacao;

import aplicacao.todolist.logicadenegocios.FuncoesTarefa;
import aplicacao.todolist.model.NivelPrioridade;
import aplicacao.todolist.model.Status;
import aplicacao.todolist.model.Tarefa;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ToDoList {

    public static void main(String[] args) {
        FuncoesTarefa servicoDeTarefas = new FuncoesTarefa();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU TODO List ---");
            System.out.println("1. Criar Nova Tarefa");
            System.out.println("2. Visualizar Tarefa Específica");
            System.out.println("3. Deletar Tarefa");
            System.out.println("4. Listar Todas as Tarefas");
            System.out.println("5. Visualizando tarefas por categoria ---");
            System.out.println("6. Visualizando tarefas por prioridade ---");
            System.out.println("0. Sair");


            System.out.println("\n--- Visualizando tarefas por status ---");
            servicoDeTarefas.visualizarPorStatus(Status.Done);

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarTarefa(servicoDeTarefas, scanner);
                    break;
                case 2:
                    visualizarTarefa(servicoDeTarefas, scanner);
                    break;
                case 3:
                    deletarTarefa(servicoDeTarefas, scanner);
                    break;
                case 4:
                    servicoDeTarefas.listarTodasTarefas();
                    break;
                case 5:
                    servicoDeTarefas.visualizarPorCategoria("Pessoal");
                    break;
                case 6:
                    servicoDeTarefas.visualizarPorStatus(Status.ToDo);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void criarTarefa(FuncoesTarefa servicoDeTarefas, Scanner scanner) {
        System.out.print("Digite o nome da tarefa: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a descrição: ");
        String descricao = scanner.nextLine();

        LocalDateTime dataDeTermino = LocalDateTime.now();

        System.out.print("Digite a categoria: ");
        String categoria = scanner.nextLine();

        NivelPrioridade nivelPrioridade = null;
        boolean prioridadeValida = false;
        while (!prioridadeValida) {
            System.out.print("Digite o nível de prioridade (Baixa, Mediana, Alta): ");
            String prioridadeStr = scanner.nextLine();
            try {
                nivelPrioridade = NivelPrioridade.valueOf(prioridadeStr.substring(0, 1).toUpperCase() + prioridadeStr.substring(1).toLowerCase());
                prioridadeValida = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Prioridade inválida. Tente novamente.");
            }
        }

        Status status = Status.ToDo;

        Tarefa novaTarefa = new Tarefa(nome, descricao, dataDeTermino, categoria, nivelPrioridade, status);
        servicoDeTarefas.criarTarefa(novaTarefa);
        System.out.println("Tarefa '" + nome + "' criada com sucesso!");
    }

    private static void visualizarTarefa(FuncoesTarefa servicoDeTarefas, Scanner scanner) {
        System.out.print("Digite o nome da tarefa que deseja visualizar: ");
        String nome = scanner.nextLine();
        servicoDeTarefas.visualizarTarefa(nome);
    }

    private static void deletarTarefa(FuncoesTarefa servicoDeTarefas, Scanner scanner) {
        System.out.print("Digite o nome da tarefa que deseja deletar: ");
        String nome = scanner.nextLine();
        boolean deletou = servicoDeTarefas.deletarTarefa(nome);
        if (deletou) {
            System.out.println("Tarefa '" + nome + "' deletada com sucesso.");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }
}