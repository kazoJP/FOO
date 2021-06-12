package controller;

import model.exceptions.EquipaNaoExisteException;
import model.exceptions.UserInputException;

import java.io.IOException;

public interface IController {

    public void run() throws ClassNotFoundException, IOException;

    public void play();

    public void readFile();

    public void writeFile();

    public void createTeam() throws IOException;

    public void createPlayer() throws UserInputException, IOException;

    public void movePlayer() throws IOException;

    public void showTeam() throws IOException, EquipaNaoExisteException;

    public void showTeamList();

   // public void showJogos();
}
