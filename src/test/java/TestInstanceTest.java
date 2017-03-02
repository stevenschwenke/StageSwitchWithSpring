import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ClearSystemProperties;
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

    @Rule
    public final ProvideSystemProperty myPropertyHasMyValue = new ProvideSystemProperty("spring.profiles.active", "test");

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void propertyTest() {

        // TODO System-Rules seems to be not comaptible with Spring because the Spring context is created before the
        // rule above is executed. Hence, the system property is set AFTER Spring decided which property-file to load.
        // Question: Is there a way to use System-Rules with Spring?
        assertEquals("test", System.getProperty("spring.profiles.active"));

        Properties properties = applicationContext.getBean(Properties.class);
        assertEquals("test-instance", properties.getMyProperty());
    }

}
