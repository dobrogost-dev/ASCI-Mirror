package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input the file path:");
        Scanner scanner2 = new Scanner(System.in);
        String path = scanner2.nextLine();
        System.out.println(path);
        System.out.print("            ^__^\n" +
                "    _______/(oo)\n" +
                "/\\/(       /(__)\n" +
                "   | w----||    \n" +
                "   ||     ||    ");
    }
}