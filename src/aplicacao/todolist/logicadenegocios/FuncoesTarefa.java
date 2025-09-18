package aplicacao.todolist.logicadenegocios;
import aplicacao.todolist.model.*;
import java.util.ArrayList;
import java.util.Collections;


public class FuncoesTarefa {

	private final ArrayList<Tarefa> tarefas = new ArrayList<>();

	public void criarTarefa(Tarefa novaTarefa) {
		tarefas.add(novaTarefa);
		Collections.sort(tarefas);

	}

	public boolean deletarTarefa(String nomeTarefa) {
		for(Tarefa tarefa : tarefas){
			if(tarefa.getNome().equalsIgnoreCase(nomeTarefa)){
				tarefas.remove(tarefa);
				return true;
			}
		}
		return false;
	}

	public void visualizarTarefa(String nomeTarefa) {
		for(Tarefa tarefa : tarefas){
			if(tarefa.getNome().equalsIgnoreCase(nomeTarefa)){
				System.out.println(tarefa.toString());
				return;
			}
		}
		System.out.println("Tarefa não encontrada!");
	}

	public void listarTodasTarefas() {
		if (tarefas.isEmpty()) {
			System.out.println("Nenhuma tarefa cadastrada.");
			return;
		}
		System.out.println("--- Lista de Tarefas ---");
		for (Tarefa tarefa : tarefas) {
			System.out.println("Nome: " + tarefa.getNome() + ", Prioridade: " + tarefa.getNivelPrioridade() + ", Status: " + tarefa.getStatus());
		}
	}

	public void visualizarPorCategoria(String categoria) {
		boolean encontrada = false;
		for (Tarefa tarefa : tarefas) {
			if(tarefa.getCategoria().equalsIgnoreCase(categoria)) {
				System.out.println(tarefa.toString());
				encontrada = true;
			}
		}
		if (encontrada == false) {
			System.out.println("Nenhuma tarefa nessa categoria achada!");
		}
	}

	public void visualizarPorStatus(Status status) {
		boolean encontrada = false;
		for (Tarefa tarefa : tarefas) {
			if (tarefa.getStatus() == status) {
				System.out.println(tarefa);
				encontrada = true;
			}
		}
		if (encontrada == false) {
			System.out.println("Nenhuma tarefa nessa categoria achada!");
		}
	}
}