package inventionsource.com.au.bicmdjdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ProfileSwitchTest
{
    private static final Logger log = (Logger) LogManager.getLogger(ProfileSwitchTest.class.getName());

    @Test
    public void CreateProfileSwitchTest() throws Exception {
        try {
            ProfileSwitch profileSwitch = new ProfileSwitch();
            assertNotNull("assertNotNull profileSwitch", profileSwitch);
        } catch (Exception e) {
            log.error("Error: " + e);
            throw e;
        }
    }
}
