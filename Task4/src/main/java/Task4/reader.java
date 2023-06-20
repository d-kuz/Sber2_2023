package Task4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
@ComponentScan
public class reader {
    @Bean("readerF")
    public char[] readFile() throws IOException {
        String path = "C:\\Users\\Natik\\IdeaProjects\\SberPractice2_2023\\Task4\\src\\main\\java\\Task4\\Borodino.txt";
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
        char[] chars= a.toCharArray();
        return chars;
    }
}
