package model;

import model.*;
import model.exceptions.EquipaNaoExisteException;
import model.exceptions.LinhaIncorretaException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static void parse(IModel model, String path) throws LinhaIncorretaException, LinhaIncorretaException {
        List<String> linhas = lerFicheiro(path);
        //Model model = new Model();
        //Map<String, Equipa> equipas = new HashMap<>(); //nome, equipa
        //Map<Integer, Jogador> jogadores = new HashMap<>(); //numero, jogador
        //List<Jogo> jogos = new ArrayList<>();
        IEquipa ultima = null;
        Jogador j = null;
        String[] linhaPartida;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch (linhaPartida[0]) {
                case "Equipa" -> {
                    if (linhaPartida[1].isEmpty()) {
                        throw new LinhaIncorretaException();
                    } else {
                        IEquipa e = IEquipa.parse(linhaPartida[1]);
                        model.addEquipa(e);
                        ultima = e;
                    }
                }
                case "Guarda-Redes" -> {
                    j = GuardaRedes.parse(linhaPartida[1]);
                    insertPlayer(model, j, ultima);
                }
                case "Defesa" -> {
                    j = Defesa.parse(linhaPartida[1]);
                    insertPlayer(model, j, ultima);
                }
                case "Medio" -> {
                    j = Medio.parse(linhaPartida[1]);
                    insertPlayer(model, j, ultima);
                }
                case "Lateral" -> {
                    j = Lateral.parse(linhaPartida[1]);
                    insertPlayer(model, j, ultima);
                }
                case "Avancado" -> {
                    j = Avancado.parse(linhaPartida[1]);
                    insertPlayer(model, j, ultima);
                }
                case "Jogo" -> {
                    Jogo jo = Jogo.parse(linhaPartida[1]);
                    model.addJogo(jo);
                }
                //default -> throw new LinhaIncorretaException();
            }
        }
    }


    public static void insertPlayer(IModel m, IJogador j, IEquipa ultima){
        if (ultima == null) {
            if (m.getEquipas().containsKey("")) {
                m.getEquipas().get("").insereJogador(j.clone());
              } else {
                  IEquipa e = new Equipa("");
                  e.insereJogador(j.clone());
                  m.addEquipa(e);
              }
          } else {
                try {
                    m.whichEquipa(ultima.getNome()).insereJogador(j.clone());
                } catch (EquipaNaoExisteException e) {
                    e.printStackTrace();
                }
        }
    }
       public static List<String> lerFicheiro (String nomeFich){
           List<String> lines;
           Path path = Paths.get(nomeFich);
           try {
               lines = Files.readAllLines(path, StandardCharsets.UTF_8);
               //lines.stream().forEach(System.out::println);
           } catch (IOException exc) {
               lines = new ArrayList<>();
               System.out.println(exc.getMessage());
           }
           return lines;
            }
}
