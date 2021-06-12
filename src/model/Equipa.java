package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
//import java.util.List;

public class Equipa implements IEquipa{
    private String nome;
    private Map<String,IJogador> jogadores;

    public Equipa(String nome) {
        this.nome = nome;
        this.jogadores = new HashMap<>();
    }

    public Equipa(String nome, HashMap<String,IJogador> jogadores){
        this.nome = nome;
        jogadores.forEach((k,v) -> this.jogadores.put(k,v.clone()));
        //jogadores.forEach(jogador -> this.jogadores.add(jogador));
    }

    public Equipa(Equipa e){
        this.nome = e.getNome();
        this.jogadores= new HashMap<>();
        try {
           // e.jogadores.forEach(jogador -> this.jogadores.add(jogador));
            e.jogadores.forEach((k,v) -> this.jogadores.put(k,v.clone()));
        }
        catch (NullPointerException ex){
            ex.printStackTrace();
        };
    }

    public Map<String,IJogador> getJogadores(){
        return this.jogadores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void insereJogador(IJogador j) {
        jogadores.put(j.getNome(),j.clone());
    }

    public IJogador getJogador(String nome){
        IJogador j = this.jogadores.get(nome).clone();
        return j;
    }


    /*public ArrayList<model.Jogador> getJogadores() {
        return jogadores;
    }*/

    /*public void setJogadores(ArrayList<model.Jogadores_Equipa> jogadores) {
        this.jogadores = jogadores;
    }*/

    public String toString(){
        String r =  "Equipa:" + nome + "\n";
        for (IJogador j : jogadores.values()){
            r += j.toString();
        }
        return r;
    }

    @Override
    public Equipa clone(){
        return new Equipa(this);
    }
}
