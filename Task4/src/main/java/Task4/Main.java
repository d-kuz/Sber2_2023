package Task4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class Main {
    @Autowired
    public static Counter counter;
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(appConfig.class);
        context.getBean(Main.class).exec();
    }

    private void exec() throws IOException {
        counter.exec();
    }


}