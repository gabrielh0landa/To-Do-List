
let tarefas = [];
let proximoId = 1;

const botaoSalvarTarefa = document.getElementById('save-task-btn');
const botaoCancelarEdicao = document.getElementById('cancel-edit-btn');
const inputIdTarefa = document.getElementById('task-id');
const inputNomeTarefa = document.getElementById('task-name');

const inputDescricao = document.getElementById('task-description'); 
const inputDataTermino = document.getElementById('task-due-date'); 

const selectCategoria = document.getElementById('task-category');
const selectPrioridade = document.getElementById('task-priority');
const listaTarefas = document.getElementById('task-list');


function formatarData(dataString) {
    if (!dataString) return 'Sem Prazo';
    const data = new Date(dataString);
    return data.toLocaleDateString('pt-BR', { 
        year: 'numeric', month: 'numeric', day: 'numeric', 
        hour: '2-digit', minute: '2-digit' 
    });
}

function criarElementoTarefa(tarefa) {
    const itemTarefa = document.createElement('div');
    itemTarefa.className = `task-item status-${tarefa.status.toLowerCase()}`;
    itemTarefa.setAttribute('data-id', tarefa.id);

    const textoBotaoConcluir = tarefa.status === 'Concluída' ? 'Concluída!' : 'Marcar como Concluída';
    const desabilitado = tarefa.status === 'Concluída' ? 'disabled' : '';

    itemTarefa.innerHTML = `
        <span class="task-name">${tarefa.nome}</span>
        <span class="task-info">
            ${tarefa.categoria} | Prioridade: ${tarefa.prioridade} | Prazo: ${formatarData(tarefa.dataDeTermino)}
        </span>
        <div class="task-details" style="font-size: 0.9em; margin-top: 5px; color: #555;">
            Descrição: ${tarefa.descricao || 'Nenhuma descrição.'}
        </div>
        <div class="task-actions">
            <button class="action-edit">Editar</button>
            <button class="action-complete" ${desabilitado}>${textoBotaoConcluir}</button>
            <button class="action-delete">Excluir</button>
        </div>
    `;

    itemTarefa.querySelector('.action-delete').addEventListener('click', function() {
        excluirTarefa(tarefa.id);
    });
    itemTarefa.querySelector('.action-complete').addEventListener('click', function() {
        mudarStatusTarefa(tarefa.id);
    });
    itemTarefa.querySelector('.action-edit').addEventListener('click', function() {
        iniciarEdicaoTarefa(tarefa.id);
    });
    
    return itemTarefa;
}


botaoSalvarTarefa.addEventListener('click', function() {
    const nome = inputNomeTarefa.value.trim();
    const descricao = inputDescricao.value.trim(); 
    const dataDeTermino = inputDataTermino.value; 
    const categoria = selectCategoria.value;
    const prioridade = selectPrioridade.value;
    const idAtual = inputIdTarefa.value;

    if (nome === '') {
        alert('Por favor, digite o nome da tarefa.');
        return;
    }

    if (idAtual) {
        for (let i = 0; i < tarefas.length; i++) {
            if (tarefas[i].id === parseInt(idAtual)) {
                tarefas[i].nome = nome;
                tarefas[i].descricao = descricao; 
                tarefas[i].dataDeTermino = dataDeTermino; 
                tarefas[i].categoria = categoria;
                tarefas[i].prioridade = prioridade;
                break;
            }
        }
        restaurarEstadoFormulario();
    } else {
        const novaTarefa = {
            id: proximoId++,
            nome: nome,
            descricao: descricao,
            dataDeTermino: dataDeTermino, 
            categoria: categoria,
            prioridade: prioridade,
            status: 'Pendente' 
        };
        tarefas.unshift(novaTarefa);
    }

    renderizarListaTarefas();
});


function excluirTarefa(idTarefa) {
    if (!confirm('Tem certeza que deseja excluir esta tarefa?')) return;
    
    tarefas = tarefas.filter(function(tarefa) {
        return tarefa.id !== idTarefa;
    });
    
    renderizarListaTarefas();
}

function mudarStatusTarefa(idTarefa) {
    for (let i = 0; i < tarefas.length; i++) {
        if (tarefas[i].id === idTarefa) {
            tarefas[i].status = tarefas[i].status === 'Pendente' ? 'Concluída' : 'Pendente';
            break;
        }
    }
    renderizarListaTarefas();
}

function iniciarEdicaoTarefa(idTarefa) {
    let tarefaParaEditar = null;
    for (let i = 0; i < tarefas.length; i++) {
        if (tarefas[i].id === idTarefa) {
            tarefaParaEditar = tarefas[i];
            break;
        }
    }

    if (!tarefaParaEditar) return;

    inputIdTarefa.value = tarefaParaEditar.id;
    inputNomeTarefa.value = tarefaParaEditar.nome;
    inputDescricao.value = tarefaParaEditar.descricao; 
    inputDataTermino.value = tarefaParaEditar.dataDeTermino; 
    selectCategoria.value = tarefaParaEditar.categoria;
    selectPrioridade.value = tarefaParaEditar.prioridade;

    botaoSalvarTarefa.textContent = 'Salvar Edição';
    botaoSalvarTarefa.classList.add('editing'); 
    botaoCancelarEdicao.style.display = 'inline-block';
    inputNomeTarefa.focus();
}

function restaurarEstadoFormulario() {
    inputIdTarefa.value = '';
    inputNomeTarefa.value = '';
    inputDescricao.value = ''; 
    inputDataTermino.value = ''; 
    selectCategoria.value = 'Pessoal';
    selectPrioridade.value = 'Alta';

    botaoSalvarTarefa.textContent = 'Adicionar Tarefa';
    botaoSalvarTarefa.classList.remove('editing');
    botaoCancelarEdicao.style.display = 'none';
}

botaoCancelarEdicao.addEventListener('click', restaurarEstadoFormulario);


function renderizarListaTarefas() {
    listaTarefas.innerHTML = ''; 
    
    for (let i = 0; i < tarefas.length; i++) {
        const item = criarElementoTarefa(tarefas[i]);
        listaTarefas.appendChild(item);
    }
}

tarefas.push({ 
    id: proximoId++, 
    nome: 'Revisar modelo Java da Tarefa', 
    descricao: 'Garantir que todos os campos estejam no front-end.', 
    dataDeTermino: '2025-09-20T14:30', 
    categoria: 'Trabalho', 
    prioridade: 'Alta', 
    status: 'Pendente' 
});
tarefas.push({ 
    id: proximoId++, 
    nome: 'Agendar consulta com dentista', 
    descricao: 'Não esqueça de ligar para a clínica.', 
    dataDeTermino: '2025-09-25T10:00', 
    categoria: 'Saude', 
    prioridade: 'Média', 
    status: 'Concluída' 
});


renderizarListaTarefas();