import java.util.ArrayList;

public class Guarda_Redes extends Jogador{
    private int elasticidade;

    public Guarda_Redes(int id, String nome, int resistencia, int destreza, int impulsao, int jogo_cabeça, int remate, int passe, ArrayList<String> historico_clubes, int elasticidade) {
        super(id, nome, resistencia, destreza, impulsao, jogo_cabeça, remate, passe, historico_clubes);
        this.elasticidade=elasticidade;
    }

    public int getElasticidade() {
        return elasticidade;
    }

    public void setElasticidade(int elasticidade) {
        this.elasticidade = elasticidade;
    }
}
