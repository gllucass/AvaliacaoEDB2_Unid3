public class ArvoreAVL {
    private NoAVL raiz;

    // Método para obter a altura de um nó
    private int altura(NoAVL N) {
        return N == null ? 0 : N.altura;
    }

    // Rotação à direita
    private NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerda;
        NoAVL T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    // Rotação à esquerda
    private NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direita;
        NoAVL T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    // Obter o fator de balanceamento de um nó
    private int getBalance(NoAVL N) {
        return N == null ? 0 : altura(N.esquerda) - altura(N.direita);
    }

    // Inserir uma reserva na árvore AVL
    public void inserirReserva(Reserva reserva) {
        raiz = inserir(raiz, reserva);
    }

    private NoAVL inserir(NoAVL node, Reserva reserva) {
        if (node == null)
            return new NoAVL(reserva);

        if (reserva.getId() < node.reserva.getId())
            node.esquerda = inserir(node.esquerda, reserva);
        else if (reserva.getId() > node.reserva.getId())
            node.direita = inserir(node.direita, reserva);
        else
            return node;

        node.altura = 1 + Math.max(altura(node.esquerda), altura(node.direita));

        int balance = getBalance(node);

        // Caso 1 - Rotação à direita
        if (balance > 1 && reserva.getId() < node.esquerda.reserva.getId())
            return rotacaoDireita(node);

        // Caso 2 - Rotação à esquerda
        if (balance < -1 && reserva.getId() > node.direita.reserva.getId())
            return rotacaoEsquerda(node);

        // Caso 3 - Rotação à esquerda-direita
        if (balance > 1 && reserva.getId() > node.esquerda.reserva.getId()) {
            node.esquerda = rotacaoEsquerda(node.esquerda);
            return rotacaoDireita(node);
        }

        // Caso 4 - Rotação à direita-esquerda
        if (balance < -1 && reserva.getId() < node.direita.reserva.getId()) {
            node.direita = rotacaoDireita(node.direita);
            return rotacaoEsquerda(node);
        }

        return node;
    }

    // Método para remover uma reserva
    public void removerReserva(int id) {
        raiz = remover(raiz, id);
    }

    private NoAVL remover(NoAVL root, int id) {
        if (root == null)
            return root;

        if (id < root.reserva.getId())
            root.esquerda = remover(root.esquerda, id);
        else if (id > root.reserva.getId())
            root.direita = remover(root.direita, id);
        else {
            if ((root.esquerda == null) || (root.direita == null)) {
                NoAVL temp = root.esquerda != null ? root.esquerda : root.direita;

                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                NoAVL temp = minValueNode(root.direita);
                root.reserva = temp.reserva;
                root.direita = remover(root.direita, temp.reserva.getId());
            }
        }

        if (root == null)
            return root;

        root.altura = Math.max(altura(root.esquerda), altura(root.direita)) + 1;

        int balance = getBalance(root);

        // Caso 1 - Rotação à direita
        if (balance > 1 && getBalance(root.esquerda) >= 0)
            return rotacaoDireita(root);

        // Caso 2 - Rotação à esquerda
        if (balance < -1 && getBalance(root.direita) <= 0)
            return rotacaoEsquerda(root);

        // Caso 3 - Rotação à esquerda-direita
        if (balance > 1 && getBalance(root.esquerda) < 0) {
            root.esquerda = rotacaoEsquerda(root.esquerda);
            return rotacaoDireita(root);
        }

        // Caso 4 - Rotação à direita-esquerda
        if (balance < -1 && getBalance(root.direita) > 0) {
            root.direita = rotacaoDireita(root.direita);
            return rotacaoEsquerda(root);
        }

        return root;
    }

    private NoAVL minValueNode(NoAVL node) {
        NoAVL current = node;
        while (current.esquerda != null)
            current = current.esquerda;
        return current;
    }

    // Método para buscar uma reserva pelo ID
    public Reserva buscarReserva(int id) {
        return buscar(raiz, id);
    }

    private Reserva buscar(NoAVL node, int id) {
        if (node == null || node.reserva.getId() == id)
            return node != null ? node.reserva : null;

        if (node.reserva.getId() > id)
            return buscar(node.esquerda, id);

        return buscar(node.direita, id);
    }

    public void listarReservasPorVoo(String voo) {
        System.out.println(Reserva.getTableHeader());
        System.out.println("-------------------------------------------------------------");
        listarReservasPorVoo(raiz, voo);
    }

    private void listarReservasPorVoo(NoAVL node, String voo) {
        if (node != null) {
            listarReservasPorVoo(node.esquerda, voo);
            if (node.reserva.getVoo().equals(voo))
                System.out.println(node.reserva);
            listarReservasPorVoo(node.direita, voo);
        }
    }

    // Método para imprimir a árvore em pré-ordem
    public void imprimirEmPreOrdem() {
        System.out.println(Reserva.getTableHeader());
        System.out.println("-------------------------------------------------------------");
        imprimirPreOrdem(raiz);
    }

    private void imprimirPreOrdem(NoAVL node) {
        if (node != null) {
            System.out.println(node.reserva);
            imprimirPreOrdem(node.esquerda);
            imprimirPreOrdem(node.direita);
        }
    }

}
