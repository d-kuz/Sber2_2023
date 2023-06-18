package Task4;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            String a = text.readFile("C:\\Users\\Natik\\IdeaProjects\\SberPractice2_2023\\Task4\\src\\main\\java\\Task4\\Borodino.txt");
            System.out.println(a);
            int c = pars.countWorld(a);
            Writer.Report(c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}