package net.prodigylabs.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    public static final Properties properties = new Properties();
    static {
        try{
            FileInputStream in = new FileInputStream("config.properties");
            properties.load(in);
            in.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
