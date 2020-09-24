package nl.han.ica.oose.dea;

import java.io.IOException;
import java.util.Properties;

public class DatabaseProperties {

    private Properties properties;

    public DatabaseProperties() {
        loadProperties();
    }

    private void loadProperties() {
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
        return properties.getProperty("connectionString");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getUser() {
        return properties.getProperty("user");
    }

    public void loadDriver() {
        var driver = properties.getProperty("driver");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
