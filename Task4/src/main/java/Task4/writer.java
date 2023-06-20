package Task4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.HashMap;
@ComponentScan
public class writer {
    @Bean("reportF")
    public boolean report(HashMap<String, Double> map) {
        for (String key : map.keySet()) {
            if (!key.equals("0")) {
                System.out.println(String.format(key + " = %.2f ", map.get(key) * 100 / map.get("0")) + "%");
            }
        }
        System.out.println(String.format("Всего слов = %.0f", map.get("0")));
        return true;
    }
}
