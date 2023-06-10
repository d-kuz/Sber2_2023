package Task1;
import java.time.LocalTime;

public class TimeCommands implements Command{

    @Override
    public Boolean exec(String[] ar) {
        if (ar.length == 1) {
            System.out.println(LocalTime.now());
        }else {
            help();
        }
        return true;
    }

    @Override
    public String getName() {
        return "time";
    }

    public void help() {
        HelpCommands.time();
    }
}
