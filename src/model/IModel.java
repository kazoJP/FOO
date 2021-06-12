package model;

import model.exceptions.EquipaNaoExisteException;
import model.exceptions.JogadorNaoExisteException;

import java.util.List;
import java.util.Map;

public interface IModel {

    public void setEquipas(Map<String, Equipa> teams);

    //public void setJogadores(Map<String, Jogador> players);

    public void setJogos(List<Jogo> games);

    public void addEquipa(IEquipa e);

    public void result(Elenco ec, Elenco ef,String nc, String nf);

    public Elenco fazElenco(String e);

    //public void addJogador(IJogador j);

    public void addJogo(Jogo j);

    public List<Jogo> getJogos();

    public Map<String, IEquipa> getEquipas();

    public boolean hasEquipa(Equipa e);

    public boolean hasKeyEquipa(String nome);

    public IJogador whichJogador(String nome) throws JogadorNaoExisteException;

    public IEquipa whichEquipa(String nome) throws EquipaNaoExisteException;

    public void reset();
}
