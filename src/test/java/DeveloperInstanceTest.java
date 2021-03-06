import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Test for the local developer stage that doesn't use any system properties.
 */
@ContextConfiguration(classes = {Config.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
public class DeveloperInstanceTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void propertyTest() {
        Properties properties = applicationContext.getBean(Properties.class);
        assertEquals("developer-instance", properties.getStage());
    }
}
