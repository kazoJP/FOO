package model;

import model.*;
import model.exceptions.LinhaIncorretaException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static void parse(IModel model) throws LinhaIncorretaException, LinhaIncorretaException {
        List<String> linhas = lerFicheiro("/home/josepeixoto/Kazo/poo/FOO/files/output.txt");
        //Model model = new Model();
        //Map<String, Equipa> equipas = new HashMap<>(); //nome, equipa
        //Map<Integer, Jogador> jogadores = new HashMap<>(); //numero, jogador
        //List<Jogo> jogos = new ArrayList<>();
        IEquipa ultima = null; Jogador j = null;
        String[] linhaPartida;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch (linhaPartida[0]) {
                case "Equipa" -> {
                    if (ultima != null) model.addEquipa(ultima.clone());
                    IEquipa e = IEquipa.parse(linhaPartida[1]);
                    //model.addEquipa(e);
                    ultima = e;
                }
                case "Guarda-Redes" -> {
                    j = GuardaRedes.parse(linhaPartida[1]);
                    model.addJogador(j);
                    if (ultima == null)
                        throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                }
                case "Defesa" -> {
                    j = Defesa.parse(linhaPartida[1]);
                    model.addJogador(j);
                    if (ultima == null)
                        throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                }
                case "Medio" -> {
                    j = Medio.parse(linhaPartida[1]);
                    model.addJogador(j);
                    if (ultima == null)
                        throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                }
                case "Lateral" -> {
                    j = Lateral.parse(linhaPartida[1]);
                    model.addJogador(j);
                    if (ultima == null)
                        throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                }
                case "Avancado" -> {
                    j = Avancado.parse(linhaPartida[1]);
                    model.addJogador(j);
                    if (ultima == null)
                        throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                }
                case "Jogo" -> {
                    Jogo jo = Jogo.parse(linhaPartida[1]);
                    model.addJogo(jo);
                }
                //default -> throw new LinhaIncorretaException();
            }
        }

        //debug
       /* for (model.Equipa e: equipas.values()){
            System.out.println(e.toString());
        }
        for (model.Jogo jog: jogos){
            System.out.println(jog.toString());
        }*/
        //return model;
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
