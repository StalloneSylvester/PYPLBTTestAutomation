package com.paypal.testutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private Properties testRunProperties;
    public PropertiesReader() {
        testRunProperties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("testrun.properties")){
            testRunProperties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String name) {
        return testRunProperties.getProperty(name);
    }

}
