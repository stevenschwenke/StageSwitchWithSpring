import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import static constants.Constants.KEY_SPRING_PROFILE;

/**
 * This class is a Java-mapping of a properties file. Every attribute in the file
 * is an attribute in this class. Which property-file is mapped is decided on the
 * configuration in the PropertySource-annotation. If a system property
 * "spring.profiles.active" is set, it is used to determine the path of the property
 * file. For the test stage, this would be "test/client.properties".
 * If no system property is set, "developer/client.properties" will be mapped.
 */
@PropertySource("classpath:${"+KEY_SPRING_PROFILE+":developer}/client.properties")
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
