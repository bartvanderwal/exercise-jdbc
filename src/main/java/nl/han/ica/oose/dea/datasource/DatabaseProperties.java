package nl.han.ica.oose.dea.datasource;

import java.io.IOException;
import java.util.Properties;

public class DatabaseProperties {

    private Properties properties;

    public void loadProperties() {
        if (properties==null) {
            properties = new Properties();
            try {
                properties.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getConnectionString() {
        loadProperties();
        return properties.getProperty("connectionString");
    }

    public String getPassword() {
        loadProperties();
        return properties.getProperty("password");
    }

    public String getUser() {
        loadProperties();
        return properties.getProperty("user");
    }

    public void loadDriver() {
        loadProperties();
        var driver = properties.getProperty("driver");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
