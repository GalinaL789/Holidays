package org.example;

/*import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;

 */


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Logger;

public class Holiday {
    private static final Logger logger = Logger.getLogger(Holiday.class.getName());

    private String name;
    private LocalDate date;

    // Constructor to initialize a Holiday object with a name and date
    public Holiday(String name, String date) {
        // Validate the holiday name before assigning it
        if (checkString(name)) {
            this.name = name.trim();
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
        if (name == null) {
            logger.severe("Holiday name is null.");
            return false; // Holiday name cannot be null.
        }
        if (name.isEmpty()) {
            logger.severe("Holiday name is empty.");
            return false; // Holiday name cannot be empty.
        }
        if (!name.matches("^[a-zA-Z ]+$")/*Allows only letters and spaces */) {
            logger.severe("Holiday name contains invalid characters.");
            return false;// Holiday name can only contain letters and spaces.
        }
        return true; // If all checks pass, the name is valid
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }
}
