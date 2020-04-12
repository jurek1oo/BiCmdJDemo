package inventionsource.com.au.bicmdjdemo;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import inventionsource.com.au.blueiriscmdj.Log4j2Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ProfileSwitchTest
{
    private static final Logger log = (Logger) LogManager.getLogger(ProfileSwitchTest.class.getName());

    @Before
    //public void setUp() throws Exception {
    //    Log4j2Config log4j = new Log4j2Config("test.log","debug");
    /// }

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
