
const listaUl = document.getElementById("listar-tarefa").querySelector("ul");
const form = document.getElementById("criar-tarefa");
const inputNome = document.getElementById("tarefa-nome");

export function renderizarTela(tarefas) {
    listaUl.innerHTML = ""; 

    if (tarefas.length === 0) {
        listaUl.innerHTML = `<li>Você ainda não tem tarefas. Adicione uma!</li>`;
        return;
    }

    tarefas.forEach(tarefa => {
        const li = document.createElement('li');
        li.dataset.id = tarefa.id;
        
        if (tarefa.status === 'done') {
            li.classList.add('tarefa-concluida');
        }
        
        li.innerHTML = `
            <input type="checkbox" class="marcar-tarefa" ${tarefa.status === 'done' ? 'checked' : ''}>
          
                <span class="nome-tarefa">${tarefa.nome}</span>
                <span class="nome-tarefa">${tarefa.descricao}</span>
                <span class="status-texto status-${tarefa.status}">${tarefa.status}</span>
                <span class="prioridade-texto prioridade-${tarefa.prioridade}">${tarefa.prioridade}</span>
              
           

            <div class="acoes">
                <button class="btn-editar">Editar</button>
                <button class="btn-excluir">Excluir</button>
            </div>
        `;
        listaUl.appendChild(li);
    });
}

export function preencherFormulario(tarefa) {
    inputNome.value = tarefa.nome;
    document.getElementById("tarefa-descricao").value = tarefa.descricao;
    document.getElementById("tarefa-data").value = tarefa.dataTermino;
    document.getElementById("tarefa-prioridade").value = tarefa.prioridade;
    form.querySelector('#botao-criar-tarefa').textContent = "Salvar Alterações";
    inputNome.focus();
}

export function limparFormulario() {
    form.reset();
    form.querySelector('#botao-criar-tarefa').textContent = "Criar Tarefa";
}