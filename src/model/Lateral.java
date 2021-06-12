package model;

public class Lateral extends Jogador {
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

    public int getScore(){
        return super.getVelocidade()*3 + super.getResistencia()* +
                super.getDestreza()*2 + super.getImpulsao()*3 +
                super.getCabeca() + super.getRemate()*2 +
                super.getPasse()*3 + this.cruzamento*3;
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
    public String toString() {
        return "Lateral:" + super.toString();
    }
}
