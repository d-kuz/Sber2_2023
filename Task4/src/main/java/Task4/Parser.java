package Task4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public interface Parser {

    boolean hasNext();
    void scan() throws IOException;
    String Next();
}
