import controller.Controller;
import view.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        //Parser.lerFicheiro("/home/josepeixoto/Kazo/poo/FOO/files/output.txt");
        Parser.parse();
        View view = new View();
        Controller controller = new Controller(view);
        controller.run();

        //test facilities
        //Scanner myObj = new Scanner(System.in);
        //String jogador = myObj.nextLine();


    }
}
