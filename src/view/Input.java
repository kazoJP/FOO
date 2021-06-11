package view;

import java.io.IOException;
import java.util.Scanner;

public class Input {
    public static String[] read() throws IOException {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split(" ");
    }

    public static String readln() throws IOException {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
