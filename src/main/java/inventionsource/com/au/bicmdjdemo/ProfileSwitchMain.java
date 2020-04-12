/*
 * Invention Source (c) 2020
 * version 2.0 blueIris command fron digital imput 2020-02-05
 * version 1.0 working with file, email alert 2019-05-09
 */
package inventionsource.com.au.bicmdjdemo;

import inventionsource.com.au.blueiriscmdj.Config;
import inventionsource.com.au.blueiriscmdj.HelperSetProfiles;
import inventionsource.com.au.blueiriscmdj.Log4j2Config;
import inventionsource.com.au.blueiriscmdj.LoginParams;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author jurek
 */
public class ProfileSwitchMain {

    private static final Logger log = LogManager.getLogger(ProfileSwitchMain.class);

    public static void main(String args[]) throws Exception {
        try {
            ProfileSwitch profileSwitch = new ProfileSwitch();
        } catch (Exception e) {
            log.error("Something went wrong: ", e);
        }
    }

}
