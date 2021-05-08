import java.util.ArrayList;

public class Avancado extends Jogador{
    private int finalizaco;

    public Avancado(int id, String nome, int resistencia, int destreza, int impulsao, int jogo_cabeça, int remate, int passe, ArrayList<String> historico_clubes, int finalização) {
        super(id,nome,resistencia,destreza,impulsao,jogo_cabeça,remate,passe,historico_clubes);
        this.finalizaco = finalização;
    }

    public int getFinalizaco() {
        return finalizaco;
    }

    public void setFinalizaco(int finalizaco) {
        this.finalizaco = finalizaco;
    }
}
