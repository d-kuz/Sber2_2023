package Task1;
import java.time.LocalDate;

public class QuitCommands implements Command{

    @Override
    public Boolean exec(String[] ar) {
        if (ar.length == 1) {
            System.out.println("Завершение работы программы");
            return false;
        }else {
            help();
            return true;
        }
    }

    @Override
    public String getName() {
        return "quit";
    }

    public void help() {
        HelpCommands.quit();
    }
}
