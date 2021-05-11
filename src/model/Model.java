package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {

    private Map<String, Equipa> equipas;
    private Map<String, Jogador> jogadores;
    private List<Jogo> jogos;

    public Model(){
        this.equipas = new HashMap<>();
        this.jogadores = new HashMap<>();
        this.jogos = new ArrayList<>();
    }

    public Model(Map<String, Equipa> teams, Map<String, Jogador> players, List<Jogo> games){
        setEquipas(teams);
        setJogadores(players);
        setJogos(games);
    }

    public void setEquipas(Map<String, Equipa> teams){
        this.equipas = new HashMap<>();
        teams.forEach((k,v) -> this.equipas.put(k,v.clone()));
    }

    public void setJogadores(Map<String, Jogador> players){
        this.jogadores = new HashMap<>();
        players.forEach((k,v) -> this.jogadores.put(k,v.clone()));
    }

    public void setJogos(List<Jogo> games){
        this.jogos = new ArrayList<>();
        games.forEach(jogo -> this.jogos.add(jogo));
    }

    public void addEquipa(Equipa e){
        this.equipas.put(e.getNome(), e);
    }

    public void addJogador(Jogador j){
        this.jogadores.put(j.getNome(),j);
    }

    public void addJogo(Jogo j){
        this.jogos.add(j);
    }

    public HashMap<String, Equipa> getEquipas(){
        return (HashMap) this.equipas;
    }


}
