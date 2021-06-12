package controller;

import model.*;
import model.exceptions.EquipaNaoExisteException;
import model.exceptions.JogadorNaoExisteException;
import model.exceptions.LinhaIncorretaException;
import model.exceptions.UserInputException;
import utilities.Config;
import view.Input;
import view.Output;
import view.View;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class Controller implements IController {

    //private final View view;

    private final IModel model;

    public Controller(IModel model) {
        this.model = model;
    }

    /*public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }*/

    public void run() throws ClassNotFoundException, IOException {
        Method[] methods = Class.forName("controller.IController").getMethods();
        String[] input;
        do {
            Output.prompt("Gest", "");
            input = Input.read();
            if (input[0].equals("help")) showMethods(methods);
            else if (input[0].equals("clear")) Output.clear();
            else callMethod(Class.forName("controller.IController"), methods, input);
        } while (!utilities.Tools.isExit(input[0]));
    }

    public void play(){
        try{
            System.out.println("Equipa da casa");
            String ec = Input.readln();
            System.out.println("Equipa da fora");
            String ef = Input.readln();
            LocalDate data = LocalDate.now();
            Elenco elc = model.fazElenco(ec);
            Elenco elf = model.fazElenco(ef);
            model.result(elc,elf,ec,ef);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void showMethods(Method[] methods) throws ClassNotFoundException {
        for (int i = 0; i < methods.length; i++) {
            Output.show(methods[i].getName());
            Parameter[] parameters = methods[i].getParameters();
            for (int j = 0; j < parameters.length; j++) {
                for (String string :
                        Arrays.asList(" ", parameters[j].getType().getName().replace("java.lang.", ""))) {
                    Output.show(string);
                }
            }
            Output.showln(" ");
        }
        Output.showln("quit");
    }

    private void callMethod(Class clazz, Method[] methods, String[] input) {
        try {
            if (!utilities.Tools.isExit(input[0])) {
                for (int i = 0; i < methods.length; i++)
                    if (methods[i].getName().equals(input[0])) {
                        methods[i].invoke(
                                this,
                                utilities.Tools.argsGenerator(
                                        Arrays.copyOfRange(input, 1, input.length), methods[i].getParameterTypes()));
                    }
            } else {

            }
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            Output.showln(Config.InvalidOption);
            e.printStackTrace();
        }
    }

    /*
        public void run() throws LinhaIncorretaException, EquipaNaoExisteException {
            Scanner scanner = new Scanner(System.in);
            try {
                Parser.parse(model);
            } catch (LinhaIncorretaException e){
                view.error(e.getMessage());
            }
            boolean in = true;
            this.view.showln(greeter);
            while (in) {
                String input = scanner.nextLine();
                if (input.length() > 0) {
                    switch (input) {
                        case "1" -> {
                            view.show("Escolha um nome para a equipa\n");
                            String name = scanner.nextLine();
                            if (model.hasKeyEquipa(name))
                                view.show("Equipa ja existe\n");
                            else {
                                Equipa e = new Equipa(name);
                                model.addEquipa(e);
                                view.show(e.toString());
                            }
                        }
                        case "2" -> {
                            view.show("Escolha a posicao do jogador\n");
                            String posicao = scanner.nextLine();
                            view.show("nome velocidade resistencia destreza impulsao cabeca remate passe ...\n");
                            String command = scanner.nextLine();
                            String[] stats = command.split(" ");
                            Jogador jog = new Jogador();
                            try {
                                if (stats.length > 8) jog = createPlayer(posicao, command);
                            } catch (UserInputException e) {
                                view.error(e.getMessage());
                            }
                            model.addJogador(jog);
                        }
                        case "3" -> {
                            view.show("Qual jogador a adicionar?");
                            String nome = scanner.nextLine();
                            Jogador jogador = new Jogador();
                            try {
                                jogador = model.whichJogador(nome);
                            } catch (JogadorNaoExisteException e) {
                                view.error(e.getMessage());
                            }
                            view.show("A qual equipa vamos adicionar o jogador");
                            String team = scanner.nextLine();
                            if (model.hasKeyEquipa(team))
                                try {
                                    model.whichEquipa(nome).insereJogador(jogador);
                                } catch (EquipaNaoExisteException e) {
                                    view.error(e.getMessage());
                                }
                        }
                        case "4" -> {
                            view.show("nome de equipa a consultar\n");
                            String e4 = scanner.nextLine();
                            if (model.hasKeyEquipa(e4)) {
                                Equipa t1 = model.whichEquipa(e4);
                                view.show(t1.toString());
                            }
                        }
                        case "9" -> {
                            view.show("Thank you");
                            exit(0);
                        }
                    }
                }
            }
        }
    */

    public void readFile(){
        model.reset();
        try {
            System.out.println("Nome do ficheiro");
            String path = Input.readln();
            Parser.parse(model,path);
        } catch (IOException | LinhaIncorretaException e){
            Output.error(Config.InvalidFile);
            e.printStackTrace();
        }
    }

    public void writeFile(){
        String txt;
        txt = model.getEquipas().entrySet().stream().map(
                e->e.getValue().toString()
                ).collect(Collectors.joining());
        try{
            System.out.println("Nome do ficheiro");
            String path = Input.readln();
            File f = new File(path);
            FileWriter writer = new FileWriter(path);
            writer.write(txt);
            writer.close();
        } catch (IOException e){
            System.out.println("Occurreu um erro.");
            e.printStackTrace();
        }
    }

    public void createTeam() throws IOException {
        Output.show("Escolha um nome para a equipa\n");
        String name = Input.readln();
        if (model.hasKeyEquipa(name))
            Output.error(Config.InvalidTeam);
        else {
            IEquipa e = new Equipa(name);
            model.addEquipa(e);
            Output.show(e.toString());
        }
    }

    public void createPlayer() throws UserInputException, IOException {
        Output.show("Escolha a posicao do jogador\n");
        String posicao = Input.readln();
        //Output.show("nome velocidade resistencia destreza impulsao cabeca remate passe ...\n");
        //String command = scanner.nextLine();
        //String[] stats = command.split(" ");
        //Jogador jog = new Jogador();
        /*try {
            if (stats.length > 8) jog = createPlayer(posicao, command);
        } catch (UserInputException e) {
            view.error(e.getMessage());
        }*/
        try {
            IJogador jog = new Jogador();
            switch (posicao) {
                case "GuardaRedes":
                    Output.showln(Config.GuardaRedes);
                    String statsG = Input.readln();
                    jog = GuardaRedes.parse(statsG);
                    break;
                case "Defesa":
                    Output.showln(Config.Jogador);
                    String statsD = Input.readln();
                    jog = Defesa.parse(statsD);
                    break;
                case "Medio":
                    Output.showln(Config.Medio);
                    String statsM = Input.readln();
                    jog = Medio.parse(statsM);
                    break;
                case "Lateral":
                    Output.showln(Config.Lateral);
                    String statsL = Input.readln();
                    jog = Lateral.parse(statsL);
                    break;
                case "Avancado":
                    Output.showln(Config.Jogador);
                    String statsA = Input.readln();
                    jog = Avancado.parse(statsA);
                default:
                    throw new UserInputException("Wrong position");
            }
            if(model.getEquipas().get("")!=null) {
                model.getEquipas().get("").insereJogador(jog);
            }
            else {
                IEquipa noteam = new Equipa("");
                noteam.insereJogador(jog);
                model.addEquipa(noteam);
            }
        } catch (UserInputException e) {
            Output.error(Config.InvalidInput);
            e.printStackTrace();
        }
    }

    //ao adicionar um jodador numa equipa retirar da anterior
    public void movePlayer() throws IOException {
        Output.show("Qual jogador a adicionar?");
        var nome = Input.readln();
        IJogador jogador = new Jogador();
        try {
            jogador = model.whichJogador(nome);
        } catch (JogadorNaoExisteException e) {
            Output.error(Config.InvalidPlayer);
            e.printStackTrace();
        }
        Output.show("A qual equipa vamos adicionar o jogador");
        var team = Input.readln();
        if (model.hasKeyEquipa(team))
            try {
                model.whichEquipa(nome).insereJogador(jogador);
            } catch (EquipaNaoExisteException e) {
                Output.error(Config.InvalidTeam);
                e.printStackTrace();
            }
    }

    public void showTeam() throws IOException, EquipaNaoExisteException {
        for (IEquipa e:model.getEquipas().values()) {
            if(!e.getNome().equals("")) {
                Output.show(e.getNome());
                Output.space();
            }
        }
        Output.show("nome de equipa a consultar\n");
        String team = Input.readln();
        if (model.hasKeyEquipa(team)) {
            IEquipa t = model.whichEquipa(team);
            Output.show(t.toString());
        }
        else {
            Output.show(Config.noTeam);
        }
    }

    public void showTeamList(){
        for (IEquipa e: model.getEquipas().values()) {
            if (!e.getNome().equals("")) {
                System.out.println(e.getNome());
            }
        }
    }

 //   public void showJogos(){
 //       model.getJogos().forEach(j->System.out.println(j.toString()));
 //   }
}
