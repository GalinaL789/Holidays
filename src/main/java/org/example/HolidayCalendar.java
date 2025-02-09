package org.example;

/*import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
*/

import java.util.ArrayList;
import java.util.List;

public class HolidayCalendar {
    private List<Holiday> holidays = new ArrayList<>();

    public synchronized void addHoliday(Holiday holiday) {
        if(holiday==null)
        {
           throw new IllegalArgumentException("Holiday object is null");
        }
        holidays.add(holiday);
        System.out.println("Праздник добавлен: " + holiday.getName());
    }

    public synchronized void removeHoliday(String nameToRemove) {
       int nn=-1;
       int indRem=-1;

        for (Holiday holiday : holidays){
            nn++;
            if (holiday.getName().equals(nameToRemove)) {
                indRem=nn;
                break;
            }
        }
        if (indRem!=-1) {
            holidays.remove(indRem);
            System.out.println("Праздник удален: " + nameToRemove);
        } else System.out.println("Праздник с таким именем " + nameToRemove + " не найден.");


    }

    public synchronized void displayHolidays() {
        System.out.println("Список праздников:");
        for (Holiday holiday : holidays) {
            System.out.println(holiday.getName() + " - " + holiday.getDate());
        }
    }

    public List<Holiday> getHolidays() {
        return holidays;
    }
}
