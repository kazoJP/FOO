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
}
