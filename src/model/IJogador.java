package model;

public interface IJogador {

    public String getNome();

    public void setNome(String nome);

    public int getNumeroJogador();

    public void setNumeroJogador(int numeroJogador);

    public int getVelocidade();

    public void setVelocidade(int velocidade);

    public int getResistencia();

    public void setResistencia(int resistencia);

    public int getDestreza();

    public void setDestreza(int destreza);

    public int getImpulsao();

    public void setImpulsao(int impulsao);

    public int getCabeca();

    public void setCabeça(int jogo_cabeça);

    public int getRemate();

    public void setRemate(int remate);

    public int getPasse();

    public void setPasse(int passe);

    public int getScore();

    public Jogador clone();
}
