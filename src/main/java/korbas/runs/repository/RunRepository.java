package korbas.runs.repository;

import korbas.runs.App;
import korbas.runs.database.Connector;
import korbas.runs.domain.TableData;
import korbas.runs.entity.Run;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RunRepository extends Connector {

    private Statement statement = null;
    private ResultSet resultSet = null;

    public List<Run> getAllRuns() {
        String sql = "";
        Connection connection = getConnection();
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
            closeConnection(resultSet, statement);
        }
        return null;
    }
}
