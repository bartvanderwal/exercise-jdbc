package nl.han.ica.oose.dea.datasource;

import nl.han.ica.oose.dea.DatabaseProperties;
import nl.han.ica.oose.dea.domain.Item;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;
import java.util.logging.Logger;

public class ItemDao {

    DatabaseProperties dbProps = new DatabaseProperties();

    private Logger logger = Logger.getLogger(getClass().getName());

    public List<Item> findAll() {

        Connection cnEmps = null;
        try {
            // Source voor `?serverTimezone=UTC`: https://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue
            cnEmps = DriverManager.getConnection(dbProps.getConnectionString(), dbProps.getUser(), dbProps.getPassword());

            ResultSet rsEmps = null;
            Statement st = cnEmps.prepareStatement("SELECT Name, Salary FROM Employees");
            rsEmps = st.executeQuery("SELECT Name, Salary FROM Employees");

            while ((rsEmps.next() != false)) {
                String name = rsEmps.getString("Name");
                BigDecimal salary = rsEmps.getBigDecimal("Salary");
                System.out.println("naam: " + name);
            }
        } catch (SQLException e) {
            logger.severe("Database error: " + e);
        }
        return null;
    }
}
