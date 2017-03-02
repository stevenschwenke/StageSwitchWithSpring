import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import static constants.Constants.KEY_SPRING_PROFILE;

@PropertySource("classpath:${"+KEY_SPRING_PROFILE+":developer}/client.properties")
@Configuration
public class Properties
{
    @Value("${web.app.name}")
    private String webAppName;

    @Value("${my.property}")
    private String myProperty;

    public String getWebAppName() {
        return webAppName;
    }

    public String getMyProperty() {
        return myProperty;
    }
}