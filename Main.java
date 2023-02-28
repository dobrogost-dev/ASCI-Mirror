package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input the file path:");
        Scanner scanner2 = new Scanner(System.in);
        String path = scanner2.nextLine();
        File file = new File(path);
        int longest = 0;
        ArrayList<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                list.add(line);
                if (line.length() > longest) {
                    longest = line.length();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        for (String line : list) {
            int diffirence = longest - line.length();
            StringBuilder str = new StringBuilder(line);
            while (diffirence > 0) {
                str.append(" ");
                diffirence--;
            }
            line = str.toString();
            System.out.print(line + " | " + line + "\n");
        }
    }
}