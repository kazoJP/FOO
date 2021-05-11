package controller;

import Utilities.Parser;
import model.Equipa;
import model.Model;
import model.exceptions.LinhaIncorretaException;
import view.View;

import java.util.Map;
import java.util.Scanner;

import static Utilities.Recursos.greeter;

public class Controller {

    private final View view;

    private final Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void run() throws LinhaIncorretaException {
        Scanner scanner = new Scanner(System.in);
        Parser.parse(model);

        /*for(Map.Entry<String, Equipa> entry : model.getEquipas().entrySet()) {
            String key = entry.getKey();
            Equipa value = entry.getValue();
            //System.out.println(key.toString());
            System.out.println(value.toString());
        }*/

        boolean in = true;
        this.view.showln(greeter);
        while(in){
            String input = scanner.nextLine();

            switch (input){
                case "1":



            }
        }

    }
}
