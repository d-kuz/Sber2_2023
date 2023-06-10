package Task1;
import java.io.File;

public class LsCommand implements Command{
    private static final String filePath ="C:\\IdeaProjects\\SberPractice2_2023\\Task1\\src\\main\\java";

    @Override
    public Boolean exec(String[] ar) {
        if (ar.length == 1) {
            File dir = new File(filePath);
            File[] files = dir.listFiles();
            for(File file: files){
                System.out.println(file.getName());
            }
        }else {
            help();
        }
        return true;
    }

    @Override
    public String getName() {
        return "ls";
    }

    public void help() {
        HelpCommands.ls();
    }
}
