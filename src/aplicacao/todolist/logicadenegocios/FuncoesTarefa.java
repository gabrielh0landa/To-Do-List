package aplicacao.todolist.logicadenegocios;
import aplicacao.todolist.model.*;
import java.time.LocalDateTime;
import java.util.ArrayList;



import java.time.LocalDateTime;
import java.util.ArrayList;

public class FuncoesTarefa {

	private final ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();

	public void criarTarefa(Tarefa novaTarefa) {
		tarefas.add(novaTarefa);
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
	
}
