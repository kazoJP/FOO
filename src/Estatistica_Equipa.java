public class Estatistica_Equipa {
    private String Equipa;
    private int pontos;
    private Elenco elenco;
    private String tatica;

    public Estatistica_Equipa(String equipa, int pontos, Elenco elenco, String tatica) {
        Equipa = equipa;
        this.pontos = pontos;
        this.elenco = elenco;
        this.tatica = tatica;
    }

    public String getEquipa() {
        return Equipa;
    }

    public void setEquipa(String equipa) {
        Equipa = equipa;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public String getTatica() {
        return tatica;
    }

    public void setTatica(String tatica) {
        this.tatica = tatica;
    }
}
