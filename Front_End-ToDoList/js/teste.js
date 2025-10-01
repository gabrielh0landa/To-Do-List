// 1. Importa TUDO que precisamos do nosso módulo de dados
import { 
    Tarefa, 
    getTarefas, 
    criarTarefa, 
    atualizarTarefa, 
    mudarStatus, 
    excluirTarefa, 
    PRIORIDADES, 
    STATUS 
} from './tarefasmodel.js';

// Função auxiliar para não repetir código
function logEstadoAtual() {
    console.log("Estado atual da lista:", getTarefas());
}

console.log("--- INICIANDO BATERIA DE TESTES ---");
logEstadoAtual(); // Deve mostrar: []

// ==================================================================
console.group("1. TESTES DE CRIAÇÃO (criarTarefa)");

try {
    console.log("1.1 Criando tarefas válidas...");
    const t1 = new Tarefa("Estudar Testes", "Criar um arquivo de teste completo", "2025-10-10", PRIORIDADES.ALTA);
    criarTarefa(t1);

    const t2 = new Tarefa("Ir ao mercado", "Comprar café e pão", "2025-10-11", PRIORIDADES.MEDIA);
    criarTarefa(t2);

    const t3 = new Tarefa("Lavar o carro", "", "2025-10-12", PRIORIDADES.BAIXA);
    criarTarefa(t3);
    console.log("✅ Sucesso! Tarefas válidas criadas.");

} catch (e) {
    console.error("❌ Falha inesperada ao criar tarefas válidas:", e.message);
}
logEstadoAtual(); // Deve mostrar 3 tarefas na lista

try {
    console.log("\n1.2 Tentando criar tarefa com prioridade inválida...");
    const tInvalida = new Tarefa("Tarefa inválida", "", "", "URGENTE");
    criarTarefa(tInvalida);
} catch (e) {
    console.log(`✅ Sucesso! Erro esperado capturado: "${e.message}"`);
}
logEstadoAtual(); // A lista não deve ter mudado.

console.groupEnd();
// ==================================================================


// ==================================================================
console.group("\n2. TESTES DE ATUALIZAÇÃO (atualizarTarefa - modo raiz)");

const atualizacoes = {
    nome: "IR AO MERCADO (ATUALIZADO!)",
    prioridade: PRIORIDADES.ALTA,
    status: STATUS.DOING
};
console.log("2.1 Atualizando tarefa com ID 2...");
atualizarTarefa(2, atualizacoes);
logEstadoAtual(); // A tarefa de ID 2 deve estar com nome, prioridade e status atualizados.

console.log("\n2.2 Tentando atualizar tarefa com ID 99 (inexistente)...");
atualizarTarefa(99, { nome: "Tarefa fantasma" }); // Deve exibir um 'warn' no console.

console.groupEnd();
// ==================================================================


// ==================================================================
console.group("\n3. TESTES DE MUDANÇA DE STATUS (mudarStatus - modo raiz)");

console.log("3.1 Mudando status da tarefa com ID 3 para 'done'...");
mudarStatus(3, STATUS.DONE);
logEstadoAtual(); // A tarefa de ID 3 deve estar com status 'done'.

console.log("\n3.2 Tentando mudar status da tarefa ID 1 para 'parado' (inválido)...");
mudarStatus(1, 'parado'); // Deve exibir um 'error' no console.

console.groupEnd();
// ==================================================================


// ==================================================================
console.group("\n4. TESTES DE EXCLUSÃO (excluirTarefa)");

console.log("4.1 Excluindo tarefa com ID 2...");
excluirTarefa(2);
logEstadoAtual(); // A lista deve ter apenas 2 tarefas (IDs 1 e 3).

console.log("\n4.2 Tentando excluir tarefa com ID 99 (inexistente)...");
excluirTarefa(99); // Deve exibir um 'warn' no console.

console.groupEnd();
// ==================================================================

console.log("\n--- BATERIA DE TESTES FINALIZADA ---");