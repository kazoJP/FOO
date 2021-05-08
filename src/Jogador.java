import java.util.ArrayList;
import java.util.Objects;


public class Jogador {

    private int id;
    private String nome;
    private int resistencia;
    private int destreza;
    private int impulsao;
    private int jogo_cabeça;
    private int remate;
    private int passe;
    private ArrayList<String> historico_clubes;

    public Jogador(int id, String nome, int resistencia, int destreza, int impulsao, int jogo_cabeça, int remate, int passe, ArrayList<String> historico_clubes) {
        this.id = id;
        this.nome = nome;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.jogo_cabeça = jogo_cabeça;
        this.remate = remate;
        this.passe = passe;
        //this.historico_clubes = historico_clubes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getImpulsao() {
        return impulsao;
    }

    public void setImpulsao(int impulsao) {
        this.impulsao = impulsao;
    }

    public int getJogo_cabeça() {
        return jogo_cabeça;
    }

    public void setJogo_cabeça(int jogo_cabeça) {
        this.jogo_cabeça = jogo_cabeça;
    }

    public int getRemate() {
        return remate;
    }

    public void setRemate(int remate) {
        this.remate = remate;
    }

    public int getPasse() {
        return passe;
    }

    public void setPasse(int passe) {
        this.passe = passe;
    }

    public ArrayList<String> getHistorico_clubes() {
        return historico_clubes;
    }

    public void setHistorico_clubes(ArrayList<String> historico_clubes) {
        this.historico_clubes = historico_clubes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogador jogador = (Jogador) o;
        return id == jogador.id && resistencia == jogador.resistencia && destreza == jogador.destreza && impulsao == jogador.impulsao && jogo_cabeça == jogador.jogo_cabeça && remate == jogador.remate && passe == jogador.passe && Objects.equals(nome, jogador.nome) && Objects.equals(historico_clubes, jogador.historico_clubes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, resistencia, destreza, impulsao, jogo_cabeça, remate, passe, historico_clubes);
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", resistencia=" + resistencia +
                ", destreza=" + destreza +
                ", impulsao=" + impulsao +
                ", jogo_cabeça=" + jogo_cabeça +
                ", remate=" + remate +
                ", passe=" + passe +
                ", historico_clubes=" + historico_clubes +
                '}';
    }
}