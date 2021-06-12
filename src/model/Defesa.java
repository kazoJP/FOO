package model;

public class Defesa extends Jogador {
    private int corte;

    public Defesa(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int jogo_cabeça, int remate, int passe) {
        super(nome, numero, velocidade, resistencia, destreza, impulsao, jogo_cabeça, remate, passe);
        //this.corte = corte;
    }

    public int getCorte() {
        return corte;
    }

    public void setCorte(int corte) {
        this.corte = corte;
    }

    public int getScore(){
        return super.getVelocidade()*2 + super.getResistencia()* +
                super.getDestreza()*3 + super.getImpulsao() +
                super.getCabeca()*3 + super.getRemate() +
                super.getPasse()*3;
    }

    public static Defesa parse(String input){
        String[] campos = input.split(",");
        return new Defesa(campos[0],
                Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]));
    }
    public String toString() {
        return "Defesa:" + super.toString();
    }
}
