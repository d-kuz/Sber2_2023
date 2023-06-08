import java.time.LocalDate;

public interface Command {
    Boolean exec(String [] ar);
    String getName();
    void help();
}
