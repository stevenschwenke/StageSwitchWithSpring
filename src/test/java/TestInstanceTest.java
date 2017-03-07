import constants.Constants;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ProvideSystemProperty;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = {Config.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestInstanceTest {

    // This has to be a ClassRule to set the property before the Spring setup started. Rule is not sufficient here.
    @ClassRule
    public static final ProvideSystemProperty provideSystemProperty = new ProvideSystemProperty(Constants.KEY_SPRING_PROFILE, "test");

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void propertyTest() {

        assertEquals("test", System.getProperty(Constants.KEY_SPRING_PROFILE)); // remove after test

        Properties properties = applicationContext.getBean(Properties.class);
        assertEquals("/MyProject/", properties.getWebAppName()); // remove after test
        assertEquals("test-instance", properties.getStage());
    }
}
