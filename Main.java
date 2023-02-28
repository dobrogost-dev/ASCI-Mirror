package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
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
        format(list, longest);
        ArrayList<String> mirrored = mirroredList(list);
        showWithMirror(list, mirrored);
    }
    public static void format(ArrayList<String> list, int longest) {
        for (int i = 0; i < list.toArray().length; i++) {
            int diffirence = longest - list.get(i).length();
            StringBuilder str = new StringBuilder(list.get(i));
            while (diffirence > 0) {
                str.append(" ");
                diffirence--;
            }
            list.set(i, str.toString());
        }
    }
    public static void showWithMirror(ArrayList<String> list, ArrayList<String> mirrored) {
        for (int i = 0; i < list.toArray().length; i++) {
            System.out.print(list.get(i) + " | " + mirrored.get(i) + "\n");
        }
    }
    public static ArrayList<String> mirroredList(ArrayList<String> list) {
        ArrayList<String> newList = new ArrayList<>(list);
        for (int i = 0; i < list.toArray().length; i++) {
            newList.set(i, mirrored(list.get(i)));
        }
        return newList;
    }
    public static String mirrored(String line) {
        StringBuilder str = new StringBuilder("");
        for (int i = line.length() - 1; i >= 0; i--) {
            char c = line.charAt(i);
            switch (c) {
                case '<':
                    c = '>';
                    break;
                case '>':
                    c = '<';
                    break;
                case '/':
                    c = '\\';
                    break;
                case '\\':
                    c = '/';
                    break;
                case '[':
                    c = ']';
                    break;
                case ']':
                    c = '[';
                    break;
                case '{':
                    c = '}';
                    break;
                case '}':
                    c = '{';
                    break;
                case '(':
                    c = ')';
                    break;
                case ')':
                    c = '(';
                    break;
            }
            if (c == ' ') {
                str.append(' ');
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }
}