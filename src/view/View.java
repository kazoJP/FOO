package view;

public class View {

    public void show(Object arg){
        System.out.print(arg);
    }

    public void showln(String[] args){
        for(int i = 0; i < args.length; i++)
            System.out.println(args[i]);
    }
}
