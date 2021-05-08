import java.util.ArrayList;

public class Defesa extends Jogador{
    private int corte;

    public Defesa(int id, String nome, int resistencia, int destreza, int impulsao, int jogo_cabeça, int remate, int passe, ArrayList<String> historico_clubes, int corte) {
        super(id, nome, resistencia, destreza, impulsao, jogo_cabeça, remate, passe, historico_clubes);
        this.corte = corte;
    }

    public int getCorte() {
        return corte;
    }

    public void setCorte(int corte) {
        this.corte = corte;
    }
}
