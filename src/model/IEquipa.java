package model;

public interface IEquipa {

    public static Equipa parse(String input){
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
    }
    public String getNome();

    public void setNome(String nome);

    public void insereJogador(IJogador j);

    public Equipa clone();
}
