import java.util.ArrayList;

public class Avancado extends Jogador{
    private int finalizaco;

    public Avancado(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogo_cabeça, int remate, int passe) {
        super(nome,numero, velocidade, resistencia,destreza,impulsao,jogo_cabeça,remate,passe);
        //this.finalizaco = finalização;
    }

    public int getFinalizaco() {
        return finalizaco;
    }

    public void setFinalizaco(int finalizaco) {
        this.finalizaco = finalizaco;
    }

    public static Avancado parse(String input){
        String[] campos = input.split(",");
        return new Avancado(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]));
    }

}

