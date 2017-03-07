import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import static constants.Constants.KEY_SPRING_PROFILE;

//@PropertySource("classpath:${"+KEY_SPRING_PROFILE+":developer}/client.properties")
@PropertySource("classpath:${spring.profiles.active:developer}/client.properties") // todo remove after testing and use line above
@Configuration
public class Properties
{
    @Value("${web.app.name}")
    private String webAppName;

    @Value("${stage}")
    private String stage;

    public String getWebAppName() {
        return webAppName;
    }

    public String getStage() {
        return stage;
    }
}
