package model;

import model.exceptions.EquipaNaoExisteException;
import model.exceptions.JogadorNaoExisteException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model implements IModel{

    private Map<String, IEquipa> equipas;
    private Map<String, IJogador> jogadores;
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
        games.forEach(jogo -> this.jogos.add(jogo.clone()));
    }

    public void addEquipa(IEquipa e){
        this.equipas.put(e.getNome(), e.clone());
    }

    public void addJogador(IJogador j){
        this.jogadores.put(j.getNome(),j.clone());
    }

    public void addJogo(Jogo j){
        this.jogos.add(j.clone());
    }

    public Map<String, IEquipa> getEquipas(){
        return this.equipas;
    }

    public boolean hasEquipa(Equipa e){
        return this.equipas.containsKey(e.getNome());
    }

    public boolean hasKeyEquipa(String nome){
        return this.equipas.containsKey(nome);
    }

    public IJogador whichJogador(String nome) throws JogadorNaoExisteException{
            IJogador jog= this.jogadores.get(nome);
            if (jog != null)
                return jog;
        throw new JogadorNaoExisteException(nome);

        }

        public IEquipa whichEquipa(String nome) throws EquipaNaoExisteException{
        IEquipa e = this.equipas.get(nome);
        if (e!=null)
            return e;
        throw new EquipaNaoExisteException(nome);
        }

}
