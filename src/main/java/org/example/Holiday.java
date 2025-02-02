package org.example;

/*import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;

 */


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Holiday {
    private String name;
    private LocalDate date;

    public Holiday(String name, String date) {
       if(checkString(name)){
            this.name = name;
        }
        else
        {
            System.out.println("input correct title of the Holiday, please");
            throw new RuntimeException("he title of holiday is incorrect" );
        }
        this.date = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);

    }
    private boolean checkString(String name) {
        if (name == null || name.isEmpty()) {
            return false; // Null or empty strings are not valid names
        }
        return name.matches("^[a-zA-Z]+$"); // Ensures only letters are present
    }


    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }
}
