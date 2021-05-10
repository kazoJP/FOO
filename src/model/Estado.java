package model;

import java.util.ArrayList;

public class Estado {
    private ArrayList<Equipa> equipas;
    private ArrayList<Jogador> jogadores_sem_equipa;
    private int totalEquipas;
    private int totalJogadores;
    private ArrayList<Jogo> historico_jogos;

    public Estado(ArrayList<Equipa> equipas, ArrayList<Jogador> jogadores_sem_equipa, int totalEquipas, int totalJogadores, ArrayList<Jogo> historico_jogos) {
        //this.equipas = equipas;
        //this.jogadores_sem_equipa = jogadores_sem_equipa;
        this.totalEquipas = totalEquipas;
        this.totalJogadores = totalJogadores;
        //this.historico_jogos = historico_jogos;
    }

    public ArrayList<Equipa> getEquipas() {
        return equipas;
    }

    public void setEquipas(ArrayList<Equipa> equipas) {
        this.equipas = equipas;
    }

    public ArrayList<Jogador> getJogadores_sem_equipa() {
        return jogadores_sem_equipa;
    }

    public void setJogadores_sem_equipa(ArrayList<Jogador> jogadores_sem_equipa) {
        this.jogadores_sem_equipa = jogadores_sem_equipa;
    }

    public int getTotalEquipas() {
        return totalEquipas;
    }

    public void setTotalEquipas(int totalEquipas) {
        this.totalEquipas = totalEquipas;
    }

    public int getTotalJogadores() {
        return totalJogadores;
    }

    public void setTotalJogadores(int totalJogadores) {
        this.totalJogadores = totalJogadores;
    }

    public ArrayList<Jogo> getHistorico_jogos() {
        return historico_jogos;
    }

    public void setHistorico_jogos(ArrayList<Jogo> historico_jogos) {
        this.historico_jogos = historico_jogos;
    }
}
