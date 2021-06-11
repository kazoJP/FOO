package view;

import java.awt.Color;

public class View {

    public void show(Object arg){
        System.out.print(arg);
    }

    public void showln(String[] args){
        for(int i = 0; i < args.length; i++)
            System.out.println(args[i]);
    }

    public void error(String s){
        System.out.println(Color.RED + "\n" + s + view.Color.ANSI_RESET );
    }
}
