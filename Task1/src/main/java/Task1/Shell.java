package Task1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shell {
    private  static final String filePath="C:\\IdeaProjects\\SberPractice2_2023\\Task1\\src\\main\\java\\Shell";
    List <Command> com = new ArrayList<>();
    public Shell(){
        com.add(new DateCommand());
        com.add(new HelpCommands());
        com.add(new LsCommand());
        com.add(new QuitCommands());
        com.add(new TimeCommands());
    }

    public void run(){
        Boolean next = true;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите команду: ");
            String s = scanner.nextLine();
            String[] c = s.split(" ");
            for (Command command: com) {
                if (c[0].equals(command)){
                    next = command.exec(c);
                }
            }
        }while (next);
    }

    public static void main(String[] args){
        new Shell().run();

    }
}
