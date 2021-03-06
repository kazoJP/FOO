package model;

public class GuardaRedes extends Jogador {
    private int elasticidade;

    public GuardaRedes(String nome, int numero, int velocidade, int resistencia, int destreza, int impulsao, int cabeca, int remate, int passe, int elasticidade) {
        super(nome, numero, velocidade, resistencia, destreza, impulsao, cabeca, remate, passe);
        this.elasticidade=elasticidade;
    }

    public int getElasticidade() {
        return elasticidade;
    }

    public void setElasticidade(int elasticidade) {
        this.elasticidade = elasticidade;
    }

    public int getScore(){
        return super.getVelocidade() + super.getResistencia() +
                super.getDestreza()*2 + super.getImpulsao() +
                super.getCabeca()*2 + super.getRemate() +
                super.getPasse()*3 +this.elasticidade*3;
    }







    public static GuardaRedes parse(String input) {
        String[] campos = input.split(",");
        return new GuardaRedes(campos[0], Integer.parseInt(campos[1]),
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
        return "GuardaRedes:" + super.toString();
    }
}

