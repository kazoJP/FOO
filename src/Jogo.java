import java.sql.Time;
import java.time.LocalDate;

public class Jogo {
    private Estatistica_Equipa equipa_casa;
    private Estatistica_Equipa equipa_fora;
    private LocalDate tempo;

    public Jogo(Estatistica_Equipa equipa_casa, Estatistica_Equipa equipa_fora, LocalDate tempo) {
        this.equipa_casa = equipa_casa;
        this.equipa_fora = equipa_fora;
        this.tempo = tempo;
    }

    public Estatistica_Equipa getEquipa_casa() {
        return equipa_casa;
    }

    public void setEquipa_casa(Estatistica_Equipa equipa_casa) {
        this.equipa_casa = equipa_casa;
    }

    public Estatistica_Equipa getEquipa_fora() {
        return equipa_fora;
    }

    public void setEquipa_fora(Estatistica_Equipa equipa_fora) {
        this.equipa_fora = equipa_fora;
    }
}
