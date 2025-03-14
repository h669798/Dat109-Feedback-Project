package org.example.demo;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseTest {

    // Constants:
    private static final String URL = "jdbc:postgresql://localhost:5432/Dat109FeedbackProject";
    private static final String BRUKERNAVN = "postgres";
    private static final String PASSORD = System.getenv("DB_PASSORD");

    @Test
    public void testDatabaseKobling() {
        try {
            System.out.println("Tester oppkobling mot database...");
            Connection connection = DriverManager.getConnection(URL, BRUKERNAVN, PASSORD);
            if (connection != null) {
                System.out.println("Oppkobling mot database vellykket!");
            }
        } catch (Exception e) {
        System.err.println("Kunne ikke koble til database:\n" + e.getMessage());
        }
    }
}
