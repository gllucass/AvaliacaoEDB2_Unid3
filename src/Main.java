import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreAVL sistema = new ArvoreAVL();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        // Inserindo reservas iniciais
        sistema.inserirReserva(new Reserva(1001, "Alice Silva", "V001", "2024-08-20T15:30:00"));
        sistema.inserirReserva(new Reserva(1002, "Joao Pereira", "V001", "2024-08-20T14:00:00"));
        sistema.inserirReserva(new Reserva(1003, "Maria Costa", "V001", "2024-08-20T15:00:00"));
        sistema.inserirReserva(new Reserva(1004, "Carlos Souza", "V002", "2024-08-21T09:00:00"));
        sistema.inserirReserva(new Reserva(1005, "Beatriz Lima", "V002", "2024-08-21T10:30:00"));
        sistema.inserirReserva(new Reserva(1006, "Fernanda Oliveira", "V001", "2024-08-20T16:00:00"));
        sistema.inserirReserva(new Reserva(1007, "Joaquim Ferreira", "V002", "2024-08-21T10:30:00"));
        sistema.inserirReserva(new Reserva(1008, "Manoel Leao", "V001", "2024-08-20T16:00:00"));
        sistema.inserirReserva(new Reserva(1009, "Jose Carlos", "V002", "2024-08-21T10:30:00"));
        sistema.inserirReserva(new Reserva(1010, "Andre Mateus", "V001", "2024-08-20T16:00:00"));

        int option;

        do {
            System.out.println("\n--- Menu de Interação ---");
            System.out.println("1. Buscar uma reserva");
            System.out.println("2. Listar reservas por voo");
            System.out.println("3. Remover uma reserva");
            System.out.println("4. Inserir uma nova reserva");
            System.out.println("5. Imprimir a árvore em pré-ordem");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();
            scanner.nextLine();  // Consome a nova linha após o número

            switch (option) {
                case 1:
                    System.out.print("Digite o ID da reserva para buscar: ");
                    int idBuscar = scanner.nextInt();
                    scanner.nextLine();  // Consome a nova linha
                    Reserva reserva = sistema.buscarReserva(idBuscar);
                    if (reserva != null) {
                        System.out.println("Reserva encontrada: ");
                        System.out.println(Reserva.getTableHeader());
                        System.out.println("-------------------------------------------------------------");
                        System.out.println(reserva);
                    } else {
                        System.out.println("Reserva não encontrada: ID = " + idBuscar + ".");
                    }
                    break;

                case 2:
                    System.out.print("Digite o código do voo para listar reservas: ");
                    String voo = scanner.nextLine();
                    System.out.println("Reservas do Voo " + voo + ":");
                    sistema.listarReservasPorVoo(voo);
                    break;

                case 3:
                    System.out.print("Digite o ID da reserva para remover: ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();  // Consome a nova linha
                    sistema.removerReserva(idRemover);
                    System.out.println("Após remoção da reserva " + idRemover + ":");
                    System.out.println("Reservas do Voo V001:");
                    sistema.listarReservasPorVoo("V001");
                    break;

                case 4:
                    System.out.print("Digite o ID da nova reserva: ");
                    int idInserir = scanner.nextInt();
                    scanner.nextLine();  // Consome a nova linha
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o código do voo: ");
                    String vooInserir = scanner.nextLine();

                    LocalDateTime dataHora = null;
                    boolean dataValida = false;

                    while (!dataValida) {
                        System.out.print("Digite a data da reserva (yyyy-MM-dd): ");
                        String dataStr = scanner.nextLine();
                        System.out.print("Digite a hora da reserva (HH:mm:ss): ");
                        String horaStr = scanner.nextLine();
                        String dataHoraStr = dataStr + "T" + horaStr;

                        try {
                            dataHora = LocalDateTime.parse(dataHoraStr, formatter);
                            dataValida = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Data ou hora inválidas. Por favor, use o formato yyyy-MM-dd para a data e HH:mm:ss para a hora.");
                        }
                    }

                    sistema.inserirReserva(new Reserva(idInserir, nome, vooInserir, dataHora.format(formatter)));
                    System.out.println("Reserva inserida com sucesso.");
                    break;

                case 5:
                    System.out.println("Árvore em Pré-Ordem:");
                    sistema.imprimirEmPreOrdem();
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (option != 6);

        scanner.close();
    }
}
