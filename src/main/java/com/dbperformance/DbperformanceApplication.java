package com.dbperformance;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.Scanner;

@SpringBootApplication
public class DbperformanceApplication {

    private static Connection oracleConnection;
    private static Connection postgresConnection;

    public static void main(String[] args) throws SQLException {
        try {

            setup();

            // Define test queries
            String[] oracleQueries = {
                    QueryConstants.oracleQuery1,
                    QueryConstants.oracleQuery2,
                    QueryConstants.oracleQuery3,
                    QueryConstants.oracleQuery4,
                    QueryConstants.oracleQuery5,
                    QueryConstants.oracleQuery6,
                    QueryConstants.oracleQuery7,
                    QueryConstants.oracleQuery8,
                    QueryConstants.oracleQuery9,
                    QueryConstants.oracleQuery10,
                    QueryConstants.oracleQuery11,
                    QueryConstants.oracleQuery12,
                    QueryConstants.oracleQuery13,
                    QueryConstants.oracleQuery14,
                    QueryConstants.oracleQuery15,
                    QueryConstants.oracleQuery16,
                    QueryConstants.oracleQuery17,
                    QueryConstants.oracleQuery18,
                    QueryConstants.oracleQuery19,
                    QueryConstants.oracleQuery20,
                    QueryConstants.oracleQuery21,
                    QueryConstants.oracleQuery22,
                    QueryConstants.oracleQuery23,
                    QueryConstants.oracleQuery24,
                    QueryConstants.oracleQuery25,
                    QueryConstants.oracleQuery26,
                    QueryConstants.oracleQuery27,
                    QueryConstants.oracleQuery28,
                    QueryConstants.oracleQuery29,
                    QueryConstants.oracleQuery30,
                    QueryConstants.oracleQuery31,
                    QueryConstants.oracleQuery32,
                    QueryConstants.oracleQuery33,
                    QueryConstants.oracleQuery34,
                    QueryConstants.oracleQuery35,
                    QueryConstants.oracleQuery36,
                    QueryConstants.oracleQuery37,
                    QueryConstants.oracleQuery38,
                    QueryConstants.oracleQuery39,
                    QueryConstants.oracleQuery40,
                    QueryConstants.oracleQuery41,
                    QueryConstants.oracleQuery42,
                    QueryConstants.oracleQuery43,
                    QueryConstants.oracleQuery44,
                    QueryConstants.oracleQuery45,
                    QueryConstants.oracleQuery46,
                    QueryConstants.oracleQuery47,
                    QueryConstants.oracleQuery48,
                    QueryConstants.oracleQuery49,
                    QueryConstants.oracleQuery50,
                    QueryConstants.oracleQuery51,
                    QueryConstants.oracleQuery52,
                    QueryConstants.oracleQuery53
            };

            // Define test queries
            String[] postgresQueries = {
                    QueryConstants.postgresQuery1,
                    QueryConstants.postgresQuery2,
                    QueryConstants.postgresQuery3,
                    QueryConstants.postgresQuery4,
                    QueryConstants.postgresQuery5,
                    QueryConstants.postgresQuery6,
                    QueryConstants.postgresQuery7,
                    QueryConstants.postgresQuery8,
                    QueryConstants.postgresQuery9,
                    QueryConstants.postgresQuery10,
                    QueryConstants.postgresQuery11,
                    QueryConstants.postgresQuery12,
                    QueryConstants.postgresQuery13,
                    QueryConstants.postgresQuery14,
                    QueryConstants.postgresQuery15,
                    QueryConstants.postgresQuery16,
                    QueryConstants.postgresQuery17,
                    QueryConstants.postgresQuery18,
                    QueryConstants.postgresQuery19,
                    QueryConstants.postgresQuery20,
                    QueryConstants.postgresQuery21,
                    QueryConstants.postgresQuery22,
                    QueryConstants.postgresQuery23,
                    QueryConstants.postgresQuery24,
                    QueryConstants.postgresQuery25,
                    QueryConstants.postgresQuery26,
                    QueryConstants.postgresQuery27,
                    QueryConstants.postgresQuery28,
                    QueryConstants.postgresQuery29,
                    QueryConstants.postgresQuery30,
                    QueryConstants.postgresQuery31,
                    QueryConstants.postgresQuery32,
                    QueryConstants.postgresQuery33,
                    QueryConstants.postgresQuery34,
                    QueryConstants.postgresQuery35,
                    QueryConstants.postgresQuery36,
                    QueryConstants.postgresQuery37,
                    QueryConstants.postgresQuery38,
                    QueryConstants.postgresQuery39,
                    QueryConstants.postgresQuery40,
                    QueryConstants.postgresQuery41,
                    QueryConstants.postgresQuery42,
                    QueryConstants.postgresQuery43,
                    QueryConstants.postgresQuery44,
                    QueryConstants.postgresQuery45,
                    QueryConstants.postgresQuery46,
                    QueryConstants.postgresQuery47,
                    QueryConstants.postgresQuery48,
                    QueryConstants.postgresQuery49,
                    QueryConstants.postgresQuery50,
                    QueryConstants.postgresQuery51,
                    QueryConstants.postgresQuery52,
                    QueryConstants.postgresQuery53
            };

            // Run tests for Oracle Database
            System.out.println("\nTesting Oracle Database Performance:");
            for (int i = 0; i < oracleQueries.length; i++) {
                testQueryPerformance(oracleConnection, oracleQueries[i], i);
            }

            // Run tests for PostgreSQL Database
            System.out.println("\nTesting PostgreSQL Database Performance:");
            for (int i = 0; i < postgresQueries.length; i++) {
                testQueryPerformance(postgresConnection, postgresQueries[i], i);
            }

            // Teardown - Clean up database connections
            teardown();

        } finally {
            oracleConnection.close();
            postgresConnection.close();
        }

    }

    // Setup method to establish connections and create tables with sample data
    private static void setup() throws SQLException {
        String oracleUrl = "jdbc:oracle:thin:@qaintx-scan.devqe.sjc.talarianweb.com:1521/qaintx_icm.devqe1db.devqe1.oraclevcn.com";
        String oracleUsername = "ads";
        String oraclePassword = "ads";

        String postgresUrl = "jdbc:postgresql://postgresdb03.devqe1.devqe1.oraclevcn.com:5444/intdeltanu_qaintx";
        String postgresUsername = "intdeltanu";
        String postgresPassword = "intdeltanu";

        try {
            // Establish Oracle DB connection
            oracleConnection = DriverManager.getConnection(oracleUrl, oracleUsername, oraclePassword);
            System.out.println("Connected to Oracle Database.");

            // Establish PostgreSQL DB connection
            postgresConnection = DriverManager.getConnection(postgresUrl, postgresUsername, postgresPassword);
            System.out.println("Connected to PostgreSQL Database.");

            // Setup database for testing (create tables and insert data)
            setupDatabase(oracleConnection);
            setupDatabase(postgresConnection);

        } catch (SQLException e) {
            System.err.println("Error while connecting to the database: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    // Setup database by creating tables and inserting test data
    private static void setupDatabase(Connection connection) throws SQLException {

    }


    // Teardown method to clean up the test environment by dropping tables
    private static void teardown() throws SQLException {

    }

    // Method to execute queries and measure performance
    private static void testQueryPerformance(Connection connection, String query, int i) {
        try {
            // Record start time
            long startTime = System.currentTimeMillis();

            // Execute the query
            try (Statement stmt = connection.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(query)) {
                    // Just iterate through the result set to execute the query fully
                    while (rs.next()) {
                        // Simulate processing the result (optional, can be ignored)
                    }
                }
            }

            // Record end time
            long endTime = System.currentTimeMillis();

            // Calculate and display query execution time
            long duration = endTime - startTime;
            System.out.println("Query " + i + " executed in " + duration + " ms");
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
    }
}