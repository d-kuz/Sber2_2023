package Task1;
import java.time.LocalDate;

public class DateCommand implements Command{

    @Override
    public Boolean exec(String[] ar) {
        if (ar.length == 1) {
            System.out.println(LocalDate.now());
        }else {
            help();
        }

        return true;
    }

    @Override
    public String getName() {
        return "date";
    }

    public void help() {
         HelpCommands.data();
    }
}
