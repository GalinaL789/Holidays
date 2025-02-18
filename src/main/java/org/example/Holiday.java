package org.example;

/*import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;

 */


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Holiday {
    private String name;
    private LocalDate date;

    // Constructor to initialize a Holiday object with a name and date
    public Holiday(String name, String date) {
        // Validate the holiday name before assigning it
        if (checkString(name)) {
            this.name = name.trim();
            ;
        } else {
            System.out.println("Input correct title of the Holiday, please");
            throw new IllegalArgumentException("The title of the holiday is incorrect");
        }

        // Convert the date string into a LocalDate object using ISO format
        try {
            this.date = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("The date is null");
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("The date is incorrect");
        }
    }

    // Method to check the validity of the holiday name
    private static boolean checkString(String name) {
        if (name == null || name.isEmpty()) {
            return false; // Null or empty strings are considered invalid
        }
        return name.matches("^[a-zA-Z ]+$"); // Allows only letters and spaces
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }
}
