package korbas.runs.database;

import java.sql.*;

public class Connector {
    protected Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost/";
            String user = "root";
            String password = "";
            Connection con = DriverManager.getConnection(url, user, password);
            con.setCatalog("runners");
            return con;
        } catch (SQLException exception) {
            System.out.println("SQLException: " + exception.getMessage());
            System.out.println("SQLState: " + exception.getSQLState());
            System.out.println("VendorError: " + exception.getErrorCode());
        }
        return null;
    }

    protected void closeConnection(ResultSet resultSet, Statement statement){
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
