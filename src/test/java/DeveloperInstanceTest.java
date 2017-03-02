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
public class DeveloperInstanceTest {

    @Rule
    public final ClearSystemProperties myPropertyIsCleared = new ClearSystemProperties("spring.profiles.active");

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void propertyTest() {
        Properties properties = applicationContext.getBean(Properties.class);
        assertEquals("developer-instance", properties.getMyProperty());
    }

}