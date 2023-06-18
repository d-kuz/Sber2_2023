package Task4;

import java.io.*;

public class text {

    public static String  readFile(String path) throws IOException {
        String a="";
        if (path.length() > 0) {
            try (BufferedReader fileInputStream = new BufferedReader(new FileReader
                    ("C:\\IdeaProjects\\SberPracticle2_2023\\Lessons5\\src\\Borodino.txt"))) {
                String b = fileInputStream.readLine();
                while (b != null) {
                    a += b + " ";
                    b = fileInputStream.readLine();
                }
            }
        }
        return a;

    }
}
