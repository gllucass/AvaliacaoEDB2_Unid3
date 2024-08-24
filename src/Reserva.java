public class Reserva {
    private int id;
    private String nome;
    private String voo;
    private String horario;

    public Reserva(int id, String nome, String voo, String horario) {
        this.id = id;
        this.nome = nome;
        this.voo = voo;
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getVoo() {
        return voo;
    }

    public String getHorario() {
        return horario;
    }

    public static String getTableHeader() {
        return String.format("| %-6s | %-20s | %-6s | %-20s |", "ID", "Passageiro", "Voo", "Horário");
    }

    @Override
    public String toString() {
        return String.format("| %-6d | %-20s | %-6s | %-20s |", id, nome, voo, horario);
    }
}
