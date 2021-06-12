package model;

public class Medio extends Jogador {
    private int recuperacao;
    public Medio(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int rec) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p);
        recuperacao = rec;
    }

    public int getScore(){
        return super.getVelocidade() + super.getResistencia()*2 +
                super.getDestreza()*2 + super.getImpulsao() +
                super.getCabeca()*2 + super.getRemate() +
                super.getPasse()*3+this.recuperacao*3;
    }

    public static Medio parse(String input){
        String[] campos = input.split(",");
        return new Medio(campos[0], Integer.parseInt(campos[1]),
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
        return "Medio:" + super.toString();
    }
}
