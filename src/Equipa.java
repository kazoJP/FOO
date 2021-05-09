import java.util.ArrayList;
import java.util.List;

public class Equipa {
    private String nome;
    private List<Jogador> jogadores;

    public Equipa(String nome) {
        this.nome = nome;
        jogadores = new ArrayList<>();
    }

    public static Equipa parse(String input){
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void insereJogador(Jogador j) {
        jogadores.add(j.clone());
    }

    /*public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }*/

    /*public void setJogadores(ArrayList<Jogadores_Equipa> jogadores) {
        this.jogadores = jogadores;
    }*/

    public String toString(){
        String r =  "Equipa:" + nome + "\n";
        for (Jogador j : jogadores){
            r += j.toString();
        }
        return r;
    }
}
