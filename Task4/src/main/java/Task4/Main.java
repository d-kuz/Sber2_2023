package Task4;

import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        int c = context.getBean(int.class);
        System.out.println("Количество слов в файле: "+c);

    }

    @Bean("reader")
    public String readFile() throws IOException {
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
        return a;
    }
    @Bean("counter")
    public int count(String a){
        String[] b = a.split(" ");
        return b.length;
    }



}