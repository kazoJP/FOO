package model;

import java.util.ArrayList;
import java.util.List;

public class Equipa implements IEquipa{
    private String nome;
    private List<Jogador> jogadores;

    public Equipa(String nome) {
        this.nome = nome;
        jogadores = new ArrayList<>();
    }

    public Equipa(String nome, ArrayList<Jogador> jogadores){
        this.nome = nome;
        jogadores.forEach(jogador -> this.jogadores.add(jogador.clone()));
    }

    public Equipa(Equipa e){
        this.nome = e.getNome();
        this.jogadores= new ArrayList<>();
        try {
            e.jogadores.forEach(jogador -> this.jogadores.add(jogador));
        }
        catch (NullPointerException ex){
            ex.printStackTrace();
        };
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void insereJogador(IJogador j) {
        jogadores.add(j.clone());
    }

    /*public ArrayList<model.Jogador> getJogadores() {
        return jogadores;
    }*/

    /*public void setJogadores(ArrayList<model.Jogadores_Equipa> jogadores) {
        this.jogadores = jogadores;
    }*/

    public String toString(){
        String r =  "model.Equipa:" + nome + "\n";
        for (Jogador j : jogadores){
            r += j.toString();
        }
        return r;
    }

    @Override
    public Equipa clone(){
        return new Equipa(this);
    }
}
