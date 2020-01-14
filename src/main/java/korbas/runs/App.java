package korbas.runs;

import korbas.runs.database.Connector;
import korbas.runs.domain.TableData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) {
        Statement statement = null;
        ResultSet resultSet = null;

        System.out.println("Działa!");
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Connection connection = new Connector().getConnection();
        try {
            if (connection != null) {
                statement = connection.createStatement();

                if (statement.execute("SELECT * FROM runs")) {
                    resultSet = statement.getResultSet();
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    List<String> labels = new ArrayList<>();
                    List<List<String>> rows = new ArrayList<>();
                    int columnCount = metaData.getColumnCount();
                    boolean firstRow = true;
                    while (resultSet.next()) {
                        List<String> row = new ArrayList<>();
                        for (int i = 1; i <= columnCount; i++) {
                            row.add(resultSet.getString(i));
                            if (firstRow) {
                                labels.add(metaData.getColumnLabel(i));
                            }
                        }
                        firstRow = false;
                        rows.add(row);
                    }
                    TableData tableData = new TableData(labels, rows);
                    System.out.println(tableData.toString());
                }
            }
        } catch (SQLException exception) {
            System.out.println("SQLException: " + exception.getMessage());
            System.out.println("SQLState: " + exception.getSQLState());
            System.out.println("VendorError: " + exception.getErrorCode());
        } catch (NullPointerException ex) {
            Logger logger
                    = Logger.getLogger(
                    App.class.getName());

            // Set Logger level()
            logger.setLevel(Level.WARNING);

            // Call warning method
            logger.warning(ex.getLocalizedMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) {
                } // ignore

                resultSet = null;
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException sqlEx) {
                } // ignore

                statement = null;
            }
        }
    }
}
