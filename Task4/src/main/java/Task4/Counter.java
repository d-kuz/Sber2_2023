package Task4;

import java.io.IOException;
import java.util.HashMap;

public interface Counter {
    void exec() throws IOException;
    HashMap<String, Double> count();
}
