package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    public static ConfigManager manager;
    public static final Properties prop = new Properties();

    private ConfigManager() throws IOException {
        String s = "/config.properties";
        InputStream inputStream = ConfigManager.class.getResourceAsStream(s);
        prop.load(inputStream);
    }

    public static ConfigManager getInstance(){
        if(manager==null)
        {
            synchronized (ConfigManager.class) {
                try {
                    manager = new ConfigManager();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return manager;
    }
    public String getString(String key){
        return System.getProperty(key, prop.getProperty(key));
    }
}
