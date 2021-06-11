package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jogo {
    private String equipaCasa;
    private String equipaFora;
    private int golosCasa;
    private int golosFora;
    private LocalDate date;
    private List<Integer> jogadoresCasa;
    private List<Integer> jogadoresFora;
    private Map<Integer, Integer> substituicoesCasa;
    private Map<Integer, Integer> substituicoesFora;

    public Jogo (String ec, String ef, int gc, int gf, LocalDate d,  List<Integer> jc, Map<Integer, Integer> sc,  List<Integer> jf, Map<Integer, Integer> sf){
        equipaCasa = ec;
        equipaFora = ef;
        golosCasa = gc;
        golosFora = gf;
        date = d;
        jogadoresCasa = new ArrayList<>(jc);
        jogadoresFora = new ArrayList<>(jf);
        substituicoesCasa = new HashMap<>(sc);
        substituicoesFora = new HashMap<>(sf);
    }

    public Jogo(Jogo game){
        try {
            this.jogadoresCasa= new ArrayList<>();
            this.jogadoresFora=new ArrayList<>();
            this.substituicoesCasa= new HashMap<>();
            this.substituicoesFora= new HashMap<>();
            this.equipaCasa = getEquipaCasa();
            this.equipaFora = getEquipaFora();
            this.golosCasa = getGolosCasa();
            this.golosFora = getGolosFora();
            this.date = LocalDate.now();
            this.jogadoresCasa.addAll(game.jogadoresCasa);
            this.jogadoresFora.addAll(game.jogadoresFora);
            this.substituicoesCasa.putAll(game.substituicoesCasa);
            this.substituicoesFora.putAll(game.substituicoesFora);
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    public String getEquipaCasa() {
        return equipaCasa;
    }

    public void setEquipaCasa(String equipaCasa) {
        this.equipaCasa = equipaCasa;
    }

    public String getEquipaFora() {
        return equipaFora;
    }

    public void setEquipaFora(String equipaFora) {
        this.equipaFora = equipaFora;
    }

    public int getGolosCasa() {
        return golosCasa;
    }

    public void setGolosCasa(int golosCasa) {
        this.golosCasa = golosCasa;
    }

    public int getGolosFora() {
        return golosFora;
    }

    public void setGolosFora(int golosFora) {
        this.golosFora = golosFora;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public static Jogo parse(String input){
        String[] campos = input.split(",");
        String[] data = campos[4].split("-");
        List<Integer> jc = new ArrayList<>();
        List<Integer> jf = new ArrayList<>();
        Map<Integer, Integer> subsC = new HashMap<>();
        Map<Integer, Integer> subsF = new HashMap<>();
        for (int i = 5; i < 16; i++){
            jc.add(Integer.parseInt(campos[i]));
        }
        for (int i = 16; i < 19; i++){
            String[] sub = campos[i].split("->");
            subsC.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for (int i = 19; i < 30; i++){
            jf.add(Integer.parseInt(campos[i]));
        }
        for (int i = 30; i < 33; i++){
            String[] sub = campos[i].split("->");
            subsF.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        return new Jogo(campos[0], campos[1], Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),
                LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                jc, subsC, jf, subsF);
    }

    public String toString() {
        return  "model.Jogo:" + equipaCasa + " - " + equipaFora;
        //+ " -> " + substituicoesCasa.toString()
        //+ " -> " + substitucoesFora.toString();
    }

    public Jogo clone(){
        return new Jogo(this);
    }
}

/*public class model.Jogo {
    private model.Estatistica_Equipa equipa_casa;
    private model.Estatistica_Equipa equipa_fora;
    private LocalDate tempo;

    public model.Jogo(model.Estatistica_Equipa equipa_casa, model.Estatistica_Equipa equipa_fora, LocalDate tempo) {
        this.equipa_casa = equipa_casa;
        this.equipa_fora = equipa_fora;
        this.tempo = tempo;
    }

    public model.Estatistica_Equipa getEquipa_casa() {
        return equipa_casa;
    }

    public void setEquipa_casa(model.Estatistica_Equipa equipa_casa) {
        this.equipa_casa = equipa_casa;
    }

    public model.Estatistica_Equipa getEquipa_fora() {
        return equipa_fora;
    }

    public void setEquipa_fora(model.Estatistica_Equipa equipa_fora) {
        this.equipa_fora = equipa_fora;
    }
}
*/