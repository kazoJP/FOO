import controller.Controller;
import model.Model;
import view.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        //Utilities.Parser.lerFicheiro("/home/josepeixoto/Kazo/poo/FOO/files/output.txt");
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        controller.run();

        //test facilities
        //Scanner myObj = new Scanner(System.in);
        //String jogador = myObj.nextLine();


    }
}
