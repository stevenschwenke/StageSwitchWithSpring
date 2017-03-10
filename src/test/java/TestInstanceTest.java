import constants.Constants;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ProvideSystemProperty;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Test for the test stage that uses a system property spring.profiles.active=test.
 */
@ContextConfiguration(classes = {Config.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
public class TestInstanceTest {

    // This has to be a ClassRule to set the property before the Spring setup started. Rule is not sufficient here.
    @ClassRule
    public static final ProvideSystemProperty provideSystemProperty = new ProvideSystemProperty(Constants.KEY_SPRING_PROFILE, "test");

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void propertyTest() {
        Properties properties = applicationContext.getBean(Properties.class);
        assertEquals("test-instance", properties.getStage());
    }
}
