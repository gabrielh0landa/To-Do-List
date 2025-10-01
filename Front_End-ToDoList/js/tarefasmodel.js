let tarefas = [];
let idProximaTarefa = 1;

 export const PRIORIDADES = Object.freeze({
    BAIXA: 'baixa',
    MEDIA: 'media',
    ALTA: 'alta'
});

export const STATUS = Object.freeze({
    TODO: "todo",
    DOING: "doing",
    DONE:   "done"
})

export class Tarefa{
    constructor(nome, descricao, dataTermino, prioridade, status = STATUS.TODO){
        
        if(!nome){
            throw new Error("O nome é obrigatório!")
        }
        if(!Object.values(PRIORIDADES).includes(prioridade)){
            throw new Error(`Prioridade inválida: '${prioridade}'.`);
        }
        if (!Object.values(STATUS).includes(status)) {
            throw new Error(`Status inválido: '${status}'.`);
        }

        this.id = 0;
        this.nome = nome;
        this.descricao = descricao;
        this.dataTermino = dataTermino;
        this.prioridade = prioridade;
        this.status = status;
    
    }
}

export function getTarefas(){
    return tarefas;
}

export function criarTarefa(tarefa){
    tarefa.id = idProximaTarefa++;
    tarefas.push(tarefa);
}

export function atualizarTarefa(id, dadosAtualizados) {
    let tarefaParaAtualizar = null;
    
    for (let i = 0; i < tarefas.length; i++) {
        if (tarefas[i].id === id) {
            tarefaParaAtualizar = tarefas[i]; 
            break; 
        }
    }

    if (tarefaParaAtualizar) { 
        for (const chave in dadosAtualizados) {
            tarefaParaAtualizar[chave] = dadosAtualizados[chave];
        }
    } else {
        console.warn(`Aviso: Tarefa com ID ${id} não encontrada para atualização.`);
    }
}

export function mudarStatus(id, novoStatus) {
    if (!Object.values(STATUS).includes(novoStatus)) {
        console.error(`Erro: Tentativa de mudar para um status inválido: "${novoStatus}"`);
        return;
    }

    for (let i = 0; i < tarefas.length; i++) {
        if (tarefas[i].id === id) {
            tarefas[i].status = novoStatus;
            break; 
        }
    }
}

export function excluirTarefa(id) {
    
    const tamanhoAntes = tarefas.length;
    tarefas = tarefas.filter(tarefa => tarefa.id !== id);
    if (tamanhoAntes === tarefas.length) {
        console.warn(`Aviso: Nenhuma tarefa com ID ${id} foi encontrada para exclusão.`);
    }
}



