package Task4;

import java.io.*;

public class text {

    public static String  readFile(String path) throws IOException {
        String a="";
        if (path.length() > 0) {
            try (BufferedReader fileInputStream = new BufferedReader(new FileReader(path))) {
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
