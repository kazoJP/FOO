import java.util.ArrayList;
import java.util.Objects;


public class Jogador {
    
    private String nome;
    private int numeroJogador;
    private int velocidade;
    private int resistencia;
    private int destreza;
    private int impulsao;
    private int cabeca;
    private int remate;
    private int passe;
    //private ArrayList<String> historico_clubes;

    public Jogador(String nome, int numeroJ, int velocidade, int resistencia, int destreza, int impulsao, int jogo_cabeça, int remate, int passe) {
        this.nome = nome;
        this.numeroJogador = numeroJ;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.cabeca = jogo_cabeça;
        this.remate = remate;
        this.passe = passe;
        //this.historico_clubes = new ArrayList<String>();
    }

    public Jogador(Jogador j) {
        nome = j.getNome();
        numeroJogador = j.getNumeroJogador();
        velocidade = j.getVelocidade();
        resistencia = j.getResistencia();
        destreza = j.getDestreza();
        impulsao = j.getImpulsao();
        cabeca = j.getCabeca();
        remate = j.getRemate();
        passe = j.getPasse();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroJogador() {
        return numeroJogador;
    }

    public void setNumeroJogador(int numeroJogador) {
        this.numeroJogador = numeroJogador;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
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

    public int getCabeca() {
        return cabeca;
    }

    public void setCabeça(int jogo_cabeça) {
        this.cabeca = jogo_cabeça;
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

    /*public ArrayList<String> getHistorico_clubes() {
        return historico_clubes;
    }*/

    /*public void setHistorico_clubes(ArrayList<String> historico_clubes) {
        this.historico_clubes = historico_clubes;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogador jogador = (Jogador) o;
        return resistencia == jogador.resistencia && destreza == jogador.destreza && impulsao == jogador.impulsao && cabeca == jogador.cabeca && remate == jogador.remate && passe == jogador.passe && Objects.equals(nome, jogador.nome); /*&& Objects.equals(historico_clubes, jogador.historico_clubes);*/
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, resistencia, destreza, impulsao, cabeca, remate, passe);
    }

   /* @Override
    public String toString() {
        return "Jogador{" +
                " nome='" + nome + '\'' +
                ", resistencia=" + resistencia +
                ", destreza=" + destreza +
                ", impulsao=" + impulsao +
                ", cabeça=" + cabeca +
                ", remate=" + remate +
                ", passe=" + passe +
                //", historico_clubes=" + historico_clubes +
                '}';
    }*/

    public String toString(){
        return nome +"\n";
    }

    @Override
    protected Jogador clone(){
        return new Jogador(this);
    }
}
