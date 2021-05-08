import java.util.ArrayList;

public class Medio extends Jogador{
    private int recuperacao_bola;

    public Medio(int id, String nome, int resistencia, int destreza, int impulsao, int jogo_cabeça, int remate, int passe, ArrayList<String> historico_clubes, int rb) {
        super(id, nome, resistencia, destreza, impulsao, jogo_cabeça, remate, passe, historico_clubes);
        this.recuperacao_bola=rb;
    }

    public int getRecuperacao_bola() {
        return recuperacao_bola;
    }

    public void setRecuperacao_bola(int recuperacao_bola) {
        this.recuperacao_bola = recuperacao_bola;
    }
}
