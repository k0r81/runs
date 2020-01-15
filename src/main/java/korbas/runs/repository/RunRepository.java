package korbas.runs.repository;

import korbas.runs.App;
import korbas.runs.database.Connector;
import korbas.runs.entity.Run;
import korbas.runs.utils.DateUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RunRepository extends Connector {
    private Statement statement = null;
    private ResultSet resultSet = null;

    public List<Run> getAllRuns() {
        List<Run> runs = new ArrayList<>();
        String sql = "SELECT * FROM runs";
        Connection connection = getConnection();
        try {
            if (connection != null) {
                statement = connection.createStatement();

                if (statement.execute(sql)) {
                    resultSet = statement.getResultSet();

                    while (resultSet.next()) {
                        runs.add(
                                createRun()
                        );
                    }
                }
            }
            return runs;
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

    private Run createRun() throws SQLException {
        return new Run(
                resultSet.getInt("ID_RUN"),
                resultSet.getString("name"),
                DateUtils.convertDateToLocalDate(resultSet.getDate("rundate")),
                resultSet.getDouble("distance"),
                resultSet.getInt("przewyzszenia"),
                resultSet.getString("opis"),
                resultSet.getInt("limit_uczestnikow"),
                resultSet.getString("iframe"),
                resultSet.getBoolean("isactive"),
                resultSet.getString("googlemap"),
                resultSet.getInt("sezon"),
                resultSet.getString("lokacja"),
                resultSet.getString("historia")
        );
    }
}
