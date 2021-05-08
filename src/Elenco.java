import java.util.ArrayList;

public class Elenco {
    private ArrayList<Jogador> titulares;
    private ArrayList<Jogador> suplentes;

    public Elenco(ArrayList<Jogador> titulares, ArrayList<Jogador> suplentes) {
        this.titulares = titulares;
        this.suplentes = suplentes;
    }

    public ArrayList<Jogador> getTitulares() {
        return titulares;
    }

    public void setTitulares(ArrayList<Jogador> titulares) {
        this.titulares = titulares;
    }

    public ArrayList<Jogador> getSuplentes() {
        return suplentes;
    }

    public void setSuplentes(ArrayList<Jogador> suplentes) {
        this.suplentes = suplentes;
    }
}
