package aplicacao.todolist.logicadenegocios;
import aplicacao.todolist.model.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;




import java.time.LocalDateTime;
import java.util.ArrayList;

public class FuncoesTarefa {

	private final ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();

	public void criarTarefa(Tarefa novaTarefa) {
		tarefas.add(novaTarefa);
		organizarPorPrioridade();	
	}
	
	
	public boolean deletarTarefa(String nomeTarefa) {
	    for (int i = 0; i < tarefas.size(); i++) {
	        Tarefa tarefa = tarefas.get(i);
	        if (tarefa.getNome().equalsIgnoreCase(nomeTarefa)) {
	            tarefas.remove(i);
	            System.out.println("Tarefa deletada!");
	            return true; 
	        }
	    }
	    System.out.println("Tarefa não encontrada!");
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
		return;
	}
	
	public void visualizarListaTarefa () {
		for(Tarefa tarefa : tarefas) {
			System.out.println(tarefa.toString());
		}
		return;
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
	
	
    public void organizarPorPrioridade() {
        Collections.sort(this.tarefas);   
    }
	
}
