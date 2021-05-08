import java.util.ArrayList;

public class Lateral extends Jogador{
    private int cruzamento;

    public Lateral(int id, String nome, int resistencia, int destreza, int impulsao, int jogo_cabeça, int remate, int passe, ArrayList<String> historico_clubes,int cruzamento) {
        super(id, nome, resistencia, destreza, impulsao, jogo_cabeça, remate, passe, historico_clubes);
        this.cruzamento=cruzamento;
    }

    public int getCruzamento() {
        return cruzamento;
    }

    public void setCruzamento(int cruzamento) {
        this.cruzamento = cruzamento;
    }
}
