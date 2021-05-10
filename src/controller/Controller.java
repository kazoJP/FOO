package controller;

import view.View;

import java.util.Scanner;

import static Utilities.Recursos.greeter;

public class Controller {

    private final View view;

    public Controller(View view) {
        this.view = view;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
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
