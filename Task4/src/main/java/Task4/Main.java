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
import java.util.ArrayList;
import java.util.HashMap;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        HashMap<String,Integer> map =  context.getBean(HashMap.class);
        for (String key: map.keySet()) {
            if (!key.equals("0")) {
                System.out.println(key + " = " + map.get(key)*100/ map.get("0") + "%");
            }
        }

    }

    @Bean("reader")
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
    @Bean("counter")
    public HashMap<String, Integer> count(char[] a){
        HashMap<String, Integer> b = new HashMap<>();
        b.put("0", 0);
        String world = "";
        for (char ch: a) {
            if ((ch >= 'a') & (ch <= 'я') | (ch >= 'А') & (ch <= 'Я') |
                    (ch == 'ё') | (ch == 'Ё') | (ch == '-')){
                world +=ch;
            }else if (world != ""){
                if (b.get(world) == null){
                    b.put(world, 1);
                }else {
                    b.put(world, b.get(world)+1);
                }
                world = "";
                b.put("0", b.get("0")+1);
            }
        }
        return b;
    }

}