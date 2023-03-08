package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public Properties init_properties(){
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream("./src/test/resources/config/configs.properties")) {
        properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
