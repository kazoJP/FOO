package model;

import model.*;

import java.util.ArrayList;

public class Jogadores_Equipa {
    private ArrayList<GuardaRedes> guarda_redes;
    private ArrayList<Defesa> defesas;
    private ArrayList<Medio> medios;
    private ArrayList<Lateral> laterais;
    private ArrayList<Avancado> avancados;

    public Jogadores_Equipa(ArrayList<GuardaRedes> guarda_redes, ArrayList<Defesa> defesas, ArrayList<Medio> medios, ArrayList<Lateral> laterais, ArrayList<Avancado> avancados) {
        //this.guarda_redes = guarda_redes;
        //this.defesas = defesas;
        //this.medios = medios;
        //this.laterais = laterais;
        //this.avancados = avancados;
    }

    public ArrayList<GuardaRedes> getGuarda_redes() {
        return guarda_redes;
    }

    public void setGuarda_redes(ArrayList<GuardaRedes> guarda_redes) {
        this.guarda_redes = guarda_redes;
    }

    public ArrayList<Defesa> getDefesas() {
        return defesas;
    }

    public void setDefesas(ArrayList<Defesa> defesas) {
        this.defesas = defesas;
    }

    public ArrayList<Medio> getMedios() {
        return medios;
    }

    public void setMedios(ArrayList<Medio> medios) {
        this.medios = medios;
    }

    public ArrayList<Lateral> getLaterais() {
        return laterais;
    }

    public void setLaterais(ArrayList<Lateral> laterais) {
        this.laterais = laterais;
    }

    public ArrayList<Avancado> getAvancados() {
        return avancados;
    }

    public void setAvancados(ArrayList<Avancado> avancados) {
        this.avancados = avancados;
    }
}
