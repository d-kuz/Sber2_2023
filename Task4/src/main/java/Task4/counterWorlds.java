package Task4;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class counterWorlds implements Counter {
    @Autowired
    public Parser parser;
    @Autowired
    public Report report;
    @Autowired
    public Counter counter;


    @Override
    public void exec() throws IOException {
        parser.scan();
        report.bildReport(counter.count());
    }

    @Override
    public HashMap<String, Double> count() {
        HashMap<String, Double> b = new HashMap<>();
        b.put("0", (double) 0);
        String world = "";
        while (parser.hasNext){
            String s = parser.Next();
            int i = 0;
            while (i < s.length()) {
                char ch = s.charAt(i);
                if ((ch >= 'a') & (ch <= 'я') | (ch >= 'А') & (ch <= 'Я') |
                        (ch == 'ё') | (ch == 'Ё') | (ch == '-')) {
                    world += ch;
                }else if (world.length() > 0){
                    if (b.get(world) == null) {
                        b.put(world, 1.0);
                    } else {
                        b.put(world, b.get(world) + 1);
                    }
                    b.put("0", b.get("0") + 1);
                    world = "";
                }
                i++;
            }
        }
        return b;
    }
}
