package model;

import java.util.ArrayList;

public class Elenco {
    private ArrayList<Integer> titulares;
    private ArrayList<Integer> suplentes;

    public Elenco(ArrayList<Integer> titulares, ArrayList<Integer> suplentes) {
        this.titulares = titulares;
        this.suplentes = suplentes;
    }

    public ArrayList<Integer> getTitulares() {
        return titulares;
    }

    public void setTitulares(ArrayList<Integer> titulares) {
        this.titulares = titulares;
    }

    public ArrayList<Integer> getSuplentes() {
        return suplentes;
    }

    public void setSuplentes(ArrayList<Integer> suplentes) {
        this.suplentes = suplentes;
    }
}
