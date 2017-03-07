import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

        Properties properties = ctx.getBean(Properties.class);

        System.out.println("Running on "+properties.getStage());

        // Use properties accordingly ...
//        properties.getWebAppName()
    }
}
