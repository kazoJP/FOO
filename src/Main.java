import controller.Controller;
import controller.IController;
import model.Equipa;
import model.IEquipa;
import model.IModel;
import model.Model;
import view.View;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        IModel model = new Model();
        IController controller = new Controller(model);
        controller.run();
/*
        ArrayList<Integer> list = new ArrayList<>(10);
        list.add(0,3);
        list.add(6,3);
        for (Integer i: list) {
            if (i!= null) System.out.println(i);
        }

 */

        /*
        //Utilities.Parser.lerFicheiro("/home/josepeixoto/Kazo/poo/FOO/files/output.txt");
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        controller.run();
        */
        //test facilities
        //Scanner myObj = new Scanner(System.in);
        //String jogador = myObj.nextLine();


        //}
    }
}
