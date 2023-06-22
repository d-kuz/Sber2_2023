package Task4;

import java.io.*;
import java.util.Scanner;

public class parserText implements Parser{
    public static int i = 0;
    public static boolean hasNext;
    public static Scanner scanner;
    public static String s;

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public void scan() throws IOException {
        String path = "C:\\Users\\Natik\\IdeaProjects\\SberPractice2_2023\\Task4\\src\\main\\java\\Task4\\Borodino.txt";
        File file = new File(path);
        scanner = new Scanner(file);
        hasNext = true;
        s="";
    }

    @Override
    public String Next() {
        if (scanner.hasNextLine()) {
            s = scanner.nextLine();
            String[] arr = s.split(" ");
        } else {
            hasNext = false;
        }
        return s;
    }
}
