public class Main {
    public static void main(String[] args) {
        ArvoreAVL sistema = new ArvoreAVL();

        // Inserindo reservas
        sistema.inserirReserva(new Reserva(1001, "Alice Silva", "V001", "2024-08-20T15:30:00"));
        sistema.inserirReserva(new Reserva(1002, "Joao Pereira", "V001", "2024-08-20T14:00:00"));
        sistema.inserirReserva(new Reserva(1003, "Maria Costa", "V001", "2024-08-20T15:00:00"));
        sistema.inserirReserva(new Reserva(1004, "Carlos Souza", "V002", "2024-08-21T11:30:00"));

        // Buscando uma reserva
        Reserva reserva = sistema.buscarReserva(1002);
        if (reserva != null) {
            System.out.println("Reserva encontrada: ");
            System.out.println(Reserva.getTableHeader());
            System.out.println("-------------------------------------------------------------");
            System.out.println(reserva);
        } else {
            System.out.println("Reserva não encontrada.");
        }

        // Listando reservas por voo
        System.out.println("\nReservas do Voo V001:");
        sistema.listarReservasPorVoo("V001");

        // Removendo uma reserva
        sistema.removerReserva(1003);
        System.out.println("\nApós remoção da reserva 1003:");

        // Listando novamente as reservas
        System.out.println("Reservas do Voo V001:");
        sistema.listarReservasPorVoo("V001");

        // Imprimindo a árvore em pré-ordem
        System.out.println("\nÁrvore em Pré-Ordem:");
        sistema.imprimirEmPreOrdem();
    }
}
