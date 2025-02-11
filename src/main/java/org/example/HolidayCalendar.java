package org.example;

/*import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HolidayCalendar {
    /*private List<Holiday> holidays = new ArrayList<>();

    public synchronized void addHoliday(Holiday holiday) {
        if(holiday==null)
        {
           throw new IllegalArgumentException("Holiday object is null");
        }
        holidays.add(holiday);
        System.out.println("Праздник добавлен: " + holiday.getName());*/


    private final Map<String, Holiday> holidays = new HashMap<>();

    public synchronized void addHoliday(Holiday holiday) {
        if (holiday == null) {
            throw new IllegalArgumentException("Holiday object is null");
        }
        if (holidays.containsKey(holiday.getName())) {
            System.out.println("Праздник уже существует: " + holiday.getName());
            return;
        }
        holidays.put(holiday.getName(), holiday);
        System.out.println("Праздник добавлен: " + holiday.getName());
    }

    public synchronized void removeHoliday(String nameToRemove) {
        if (holidays.remove(nameToRemove) != null) {
            System.out.println("Праздник удален: " + nameToRemove);
        } else {
            System.out.println("Праздник с таким именем " + nameToRemove + " не найден.");
        }
    }
    public synchronized void displayHolidays() {
        System.out.println("Список праздников:");
        for (Holiday holiday : holidays.values()) {
            System.out.println(holiday.getName() + " - " + holiday.getDate());
        }
    }

    public List<Holiday> getHolidays() {
        return new ArrayList<>(holidays.values()); // Возвращаем список всех праздников
    }

}
