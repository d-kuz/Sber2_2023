package Task4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.HashMap;
@ComponentScan
public class counter {
    @Bean("counterF")
    public HashMap<String, Double> count(char[] a){
        HashMap<String, Double> b = new HashMap<>();
        b.put("0", (double) 0);
        String world = "";
        for (char ch: a) {
            if ((ch >= 'a') & (ch <= 'я') | (ch >= 'А') & (ch <= 'Я') |
                    (ch == 'ё') | (ch == 'Ё') | (ch == '-')){
                world +=ch;
            }else if (world != ""){
                if (b.get(world) == null){
                    b.put(world, 1.0);
                }else {
                    b.put(world, b.get(world)+1);
                }
                world = "";
                b.put("0", b.get("0") + 1);
            }
        }
        return b;
    }
}
