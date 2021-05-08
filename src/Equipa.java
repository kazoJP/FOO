import java.util.ArrayList;

public class Equipa {
    private int id;
    private String nome;
    private ArrayList<Jogadores_Equipa> jogadores;

    public Equipa(int id, String nome, ArrayList<Jogadores_Equipa> jogadores) {
        this.id = id;
        this.nome = nome;
        //this.jogadores = jogadores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Jogadores_Equipa> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogadores_Equipa> jogadores) {
        this.jogadores = jogadores;
    }
}
