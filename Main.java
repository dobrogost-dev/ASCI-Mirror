package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input the file path:");
        Scanner scanner2 = new Scanner(System.in);
        String path = scanner2.nextLine();
        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}