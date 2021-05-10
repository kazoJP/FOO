import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    public static void parse() throws LinhaIncorretaException, LinhaIncorretaException {
        List<String> linhas = lerFicheiro("/home/josepeixoto/Kazo/poo/FOO/files/output.txt");
        Map<String, Equipa> equipas = new HashMap<>(); //nome, equipa
        Map<Integer, Jogador> jogadores = new HashMap<>(); //numero, jogador
        List<Jogo> jogos = new ArrayList<>();
        Equipa ultima = null; Jogador j = null;
        String[] linhaPartida;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "model.Equipa":
                    Equipa e = Equipa.parse(linhaPartida[1]);
                    equipas.put(e.getNome(), e);
                    ultima = e;
                    break;
                case "Guarda-Redes":
                    j = GuardaRedes.parse(linhaPartida[1]);
                    jogadores.put(j.getNumeroJogador(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "model.Defesa":
                    j = Defesa.parse(linhaPartida[1]);
                    jogadores.put(j.getNumeroJogador(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "model.Medio":
                    j = Medio.parse(linhaPartida[1]);
                    jogadores.put(j.getNumeroJogador(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "model.Lateral":
                    j = Lateral.parse(linhaPartida[1]);
                    jogadores.put(j.getNumeroJogador(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "model.Avancado":
                    j = Avancado.parse(linhaPartida[1]);
                    jogadores.put(j.getNumeroJogador(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "model.Jogo":
                    Jogo jo = Jogo.parse(linhaPartida[1]);
                    jogos.add(jo);
                    break;
                //default:
                 //   throw new LinhaIncorretaException();

            }

            /*for(Map.Entry<String, Equipa> entry : equipas.entrySet()) {
                String key = entry.getKey();
                Equipa value = entry.getValue();
                System.out.println(key.toString());
                //value.toString();
            }*/
        }

        //debug
       /* for (model.Equipa e: equipas.values()){
            System.out.println(e.toString());
        }
        for (model.Jogo jog: jogos){
            System.out.println(jog.toString());
        }*/
    }

    public static List<String> lerFicheiro(String nomeFich) {
        List<String> lines;
        Path path = Paths.get(nomeFich);
        try { lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            //lines.stream().forEach(System.out::println);
        }
        catch(IOException exc) {
            lines = new ArrayList<>();
            System.out.println(exc.getMessage());
        }
        return lines;
    }


    /*public static List<String> lerFicheiro(String file) {
        List<String> lines = new ArrayList<>();
        String line;

        try {
            BufferedReader inFile = new BufferedReader(new FileReader(file));
            while ((line = inFile.readLine()) != null) {
                lines.add(line);
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return lines;
    }*/

}
