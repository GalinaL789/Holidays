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
      //  if(name.isString)  //throw exception RunTime exception
        this.name = name;
        this.date = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        throw new RuntimeException("Privet Vasya!" );
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }
}
