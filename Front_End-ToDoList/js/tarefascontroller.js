
import * as Model from './tarefasmodel.js';
import * as View from './tarefasview.js';

let idEmEdicao = null;


function handleSubmit(event) {
    event.preventDefault();
    const form = event.target;

    const nome = form.querySelector("#tarefa-nome").value;
    const descricao = form.querySelector("#tarefa-descricao").value;
    const dataTermino = form.querySelector("#tarefa-data").value;
    const prioridade = form.querySelector("#tarefa-prioridade").value;

    try {
        if (idEmEdicao !== null) {
            Model.atualizarTarefa(idEmEdicao, { nome, descricao, dataTermino, prioridade });
        } else {
            const novaTarefa = new Model.Tarefa(nome, descricao, dataTermino, prioridade);
            Model.criarTarefa(novaTarefa);
        }
        View.limparFormulario();
        idEmEdicao = null;
        View.renderizarTela(Model.getTarefas());
    } catch (error) {
        alert(error.message);
    }
}

function handleListClick(event) {
    const el = event.target;
    const tarefaLi = el.closest('li');
    if (!tarefaLi) return;

    const id = Number(tarefaLi.dataset.id);

    if (el.classList.contains('btn-editar')) {
        const tarefa = Model.getTarefas().find(t => t.id === id);
        if (tarefa) {
            View.preencherFormulario(tarefa);
            idEmEdicao = id;
        }
    }
    if (el.classList.contains('btn-excluir')) {
        Model.excluirTarefa(id);
        View.renderizarTela(Model.getTarefas());
    }
}

function handleListChange(event) {
    const el = event.target;
    if (!el.classList.contains('marcar-tarefa')) return;
    
    const tarefaLi = el.closest('li');
    if (!tarefaLi) return;
    
    const id = Number(tarefaLi.dataset.id);
    const novoStatus = el.checked ? Model.STATUS.DONE : Model.STATUS.TODO;
    
    Model.mudarStatus(id, novoStatus);
    View.renderizarTela(Model.getTarefas());
}


export function inicializar() {
    document.getElementById('criar-tarefa').addEventListener('submit', handleSubmit);
    
    const listaUl = document.querySelector("#listar-tarefa ul");
    listaUl.addEventListener('click', handleListClick);
    listaUl.addEventListener('change', handleListChange);

    View.renderizarTela(Model.getTarefas());
}

inicializar();