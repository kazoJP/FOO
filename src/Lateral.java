import java.util.ArrayList;

public class Lateral extends Jogador{
    private int cruzamento;

    public Lateral(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int cabeça, int remate, int passe,int cruzamento) {
        super(nome, numero, velocidade, resistencia, destreza, impulsao, cabeça, remate, passe);
        this.cruzamento=cruzamento;
    }

    public int getCruzamento() {
        return cruzamento;
    }

    public void setCruzamento(int cruzamento) {
        this.cruzamento = cruzamento;
    }

    public static Lateral parse(String input){
        String[] campos = input.split(",");
        return new Lateral(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]));
    }
}
