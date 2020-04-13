/*
 * Invention Source (c) 2020
 * version 2.0 blueIris command fron digital imput 2020-02-05
 * version 1.0 working with file, email alert 2019-05-09
 */
package inventionsource.com.au.bicmdjdemo;

import inventionsource.com.au.blueiriscmdj.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

/**
 * @author jurek
 */
public class ProfileSwitch {

    private final Logger log = LogManager.getLogger(ProfileSwitch.class);
    
    final static String VERSION = "1.1";

    public ProfileSwitch() throws Exception {

        Config cfg = new Config("./config.properties");
        String HOST = cfg.getProperty("HOST");  
        String USER = cfg.getProperty("USER");  
        String PASSWORD = cfg.getProperty("PASSWORD");
        String LOG_LEVEL = cfg.getProperty("LOG_LEVEL");
        String LOG_FILE = cfg.getProperty("LOG_FILE");
        final int PROFILE1;
        final int PROFILE2;
        try {
            PROFILE1 = Integer.parseInt(cfg.getProperty("PROFILE1"));
            PROFILE2 = Integer.parseInt(cfg.getProperty("PROFILE2"));
        } catch(Exception e){
            log.error("Error parsing integer as PROFILE 1 or 2, in config.properties file.");
            throw new Exception(e.getMessage());
        }
        log.info("Starting bicmdjdemo.ProfileSwitch VERSION: " + VERSION);
        log.info("Config.properties values: " );
        log.info("HOST: " + HOST+ " USER: " + USER+ " PASSWORD: ***" + PASSWORD.length()+ "*** ");
        log.info("LOG_LEVEL: " + LOG_LEVEL + " LOG_FILE: " + LOG_FILE);
        log.info("PROFILE1: " + PROFILE1+ " PROFILE2: " + PROFILE2);

        try {
            Level level = Log4j2Config.getLevel(LOG_LEVEL);
            Configurator.setAllLevels(LogManager.getRootLogger().getName(), level);
            LoginParams login = new LoginParams(USER,PASSWORD,HOST);

            // change BI profile 2 times
            //------------------------------------------------------------------------------
            try {
                for (int i = 0; i < 2; i++) {
                    log.info("i: " + i);
                    HelperSetProfiles helper = new HelperSetProfiles(login);
                    int activeProfile = helper.GetActiveProfile();

                    log.info("lastActiveProfile: " + activeProfile);
                    if (activeProfile != PROFILE1) {
                        helper.SetActiveProfile(PROFILE1);
                    } else {
                        helper.SetActiveProfile(PROFILE2);
                    }
                    Thread.sleep(2000);
                }
                log.info("Finished.");
            } catch (Exception ex1)
            {
                log.error("Error: ", ex1);
            }
         } catch (Exception e) {
            log.error("Something went wrong: ", e);
        }
    }
}
