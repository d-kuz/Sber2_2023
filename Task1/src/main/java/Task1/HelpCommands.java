package Task1;

public class HelpCommands implements Command{
    @Override
    public Boolean exec(String[] ar) {
        if (ar.length == 1) {
            data();
            time();
            ls();
            quit();
        }else {
            help();
        }
        return true;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public void help() {
        System.out.println("help - выводит справку по командам");
    }

    public static void data(){
        System.out.println("data - выводит текущую дату");
    }
    public static void  time(){
        System.out.println("time - выводит текущее время");
    }
    public static void  ls(){
        System.out.println("ls - выводит текущий католог");
    }
    public static void quit(){
        System.out.println( "quit - завершение работы");
    }
}
