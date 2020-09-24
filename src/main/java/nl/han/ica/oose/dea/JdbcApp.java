package nl.han.ica.oose.dea;

import nl.han.ica.oose.dea.datasource.DatabaseProperties;
import nl.han.ica.oose.dea.datasource.ItemDao;

public class JdbcApp {

    public static void main(String[] args) {
        JdbcApp app = new JdbcApp();
        app.loadProperties();
        ItemDao itemDao = new ItemDao();
        itemDao.findAll();
    }

    private void loadProperties() {
        var dbProperties = new DatabaseProperties();
        dbProperties.loadProperties();
        dbProperties.loadDriver();
    }

}
