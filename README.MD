# Sistema de Gerenciamento de Reservas de Voos

Este projeto implementa um sistema para gerenciar reservas de voos de forma eficiente. Utiliza estruturas de dados Árvore AVL para garantir operações rápidas e eficazes no gerenciamento das reservas.

## Descrição do Projeto

Este projeto é parte da disciplina **DIM0117 - Estruturas de Dados Básicas II** do curso de Bacharelado em Tecnologia da Informação na **Universidade Federal do Rio Grande do Norte (UFRN)**, ministrado pelo professor **Edson Jackson de Medeiros Neto**.

O objetivo é desenvolver um sistema que permita a inserção, remoção e busca de reservas de voos, além de listar as reservas em ordem crescente de horário de partida. O sistema pode ser implementado usando uma Árvore AVL ou uma Árvore Rubro-Negra, ambas garantem operações eficientes.

## Funcionalidades

O sistema deve suportar as seguintes operações:

1. **Inserir Reserva:** Adicionar novas reservas ao sistema.
2. **Remover Reserva:** Remover reservas existentes do sistema.
3. **Buscar Reserva:** Encontrar uma reserva específica pelo identificador único.
4. **Listar Reservas por Voo:** Exibir todas as reservas de um voo em ordem crescente de horário de partida.
5. **Imprimir Árvore de Reservas:** Exibir a árvore de reservas em pré-ordem para verificar o balanceamento.
6. **Verificar Balanceamento:** Garantir que a árvore se mantenha balanceada após cada operação.

## Requisitos Técnicos

- **Linguagem:** Java
- **Estrutura de Dados:** Árvore AVL ou Árvore Rubro-Negra
- **Classes Principais:**
    - `Reserva`: Representa uma reserva com ID, nome do passageiro, código do voo e horário de partida.
    - `ArvoreBalanceada`: Implementa as operações de gerenciamento de reservas utilizando a estrutura de dados escolhida.

## Detalhes de Implementação

- **Inserção de Reserva:** A reserva é inserida na árvore de forma a manter o balanceamento.
- **Remoção de Reserva:** Lida com os casos de nó folha, nó com um filho e nó com dois filhos.
- **Busca de Reserva:** Utiliza o identificador único para localizar a reserva na árvore.
- **Listagem por Voo:** Exibe as reservas de um voo específico em ordem crescente de horário de partida.
- **Impressão em Pré-Ordem:** Mostra a estrutura da árvore em pré-ordem para verificar o balanceamento.

## Considerações Finais

Este sistema foi projetado para gerenciar reservas de voos de forma eficiente, utilizando uma estrutura de dados balanceada para garantir rapidez nas operações essenciais.

---

**Desenvolvido por:** Geraldo Lucas Bezerra Rocha  
**Disciplina:** DIM0117 - Estruturas de Dados Básicas II  
**Projeto Final da 3º Unidade**  
**Universidade Federal do Rio Grande do Norte (UFRN)**  
**Professor:** Edson Jackson de Medeiros Neto
