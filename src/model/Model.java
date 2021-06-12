package model;

import model.exceptions.EquipaNaoExisteException;
import model.exceptions.JogadorNaoExisteException;

import java.time.LocalDate;
import java.util.*;

import static java.lang.Math.abs;

public class Model implements IModel{

    private Map<String, IEquipa> equipas;
   // private Map<String, IJogador> jogadores;
    private List<Jogo> jogos;

    public Model(){
        this.equipas = new HashMap<>();
        this.jogos = new ArrayList<>();
    }

    public Model(Map<String, Equipa> teams, List<Jogo> games){ //Map<String, Jogador> players
        setEquipas(teams);
        //setJogadores(players);
        setJogos(games);
    }

    public void setEquipas(Map<String, Equipa> teams){
        this.equipas = new HashMap<>();
        teams.forEach((k,v) -> this.equipas.put(k,v.clone()));
    }

   /* public void setJogadores(Map<String, Jogador> players){
        this.jogadores = new HashMap<>();
        players.forEach((k,v) -> this.jogadores.put(k,v.clone()));
    }
*/
    public void setJogos(List<Jogo> games){
        this.jogos = new ArrayList<>();
        games.forEach(jogo -> this.jogos.add(jogo.clone()));
    }

    public void addEquipa(IEquipa e){
        this.equipas.put(e.getNome(), e.clone());
    }

 /*   public void addJogador(IJogador j){
        this.jogadores.put(j.getNome(),j.clone());
    }
*/
    public void addJogo(Jogo j){
        this.jogos.add(j.clone());
    }

    public List<Jogo> getJogos(){
        return this.jogos;
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

    public IJogador whichJogador(String nome) throws JogadorNaoExisteException {
        Collection<IEquipa> eqs = this.equipas.values();
        IJogador j = null;
        for (IEquipa e : eqs) {
            if (e.getJogador(nome) != null) {
                j = e.getJogador(nome);
            }
        }
        if (j == null) { throw new JogadorNaoExisteException(nome); }
        return j;
    }

        public IEquipa whichEquipa(String nome) throws EquipaNaoExisteException{
        IEquipa e = this.equipas.get(nome);
        if (e!=null)
            return e;
        throw new EquipaNaoExisteException(nome);
        }

    public Elenco fazElenco(String e){
        ArrayList<Integer> titulares = new ArrayList<>();
        ArrayList<Integer> suplentes = new ArrayList<>();
        for (IJogador j: this.getEquipas().get(e).getJogadores().values()) {
            int i=0;
            if(i<=11) {
                titulares.add(j.getNumeroJogador());
            }else{
                suplentes.add(j.getNumeroJogador());
            }
            i++;
        }
        return new Elenco(titulares,suplentes);
    }

    public void result(Elenco ec, Elenco ef,String nc, String nf){
        int golosc = 0;
        int golof = 0;
        int ecvalue =0;
        int efvalue=0;
        float f=0;
        int random;
        Random r = new Random();
        for(Integer j : ec.getTitulares()){
            ecvalue += j;
        }
        for(Integer j : ef.getTitulares()){
            efvalue += j;
        }
        f = abs((ecvalue-efvalue))/ecvalue;
        random =r.nextInt(100);
        if(random<20){
            golosc +=1;
        } else if(random>80){
            golof=+1;
        }
        random = r.nextInt(100);
        if(random<20){golosc +=1;} else if(random>80){ golof=+1;}
        random = r.nextInt(100);
        if(random<20){golosc +=1;} else if(random>80){ golof=+1;}
        random = r.nextInt(100);
        if(random<20){golosc +=1;} else if(random>80){ golof=+1;}
        HashMap<Integer,Integer> sbc = new HashMap<Integer, Integer>();
        HashMap<Integer,Integer> sbf = new HashMap<Integer, Integer>();
        sbc.put(ec.getTitulares().indexOf(1),ec.getSuplentes().indexOf(1));
        sbf.put(ef.getTitulares().indexOf(1),ef.getSuplentes().indexOf(1));
       Jogo jogo = new Jogo(nc,nf,golosc,golof, LocalDate.now(),ec.getTitulares(),sbc,ef.getTitulares(),sbf);
       this.addJogo(jogo);
       if(golof>golosc){
           System.out.println(nf + " ganha");
           System.out.println(golosc + " - " + golof);
       }
       else {
           if (golof < golosc) {
               System.out.println(nc + " ganha");
               System.out.println(golosc + " - " + golof);
           }
           else{System.out.println( "Empate");}
       }
    }

    public void reset() {
        this.equipas.clear();
        this.jogos.clear();
    }
}
