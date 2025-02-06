package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HolidayCalendarTest {
    private static Holiday holiday;
    private static HolidayCalendar holidayCalendar;


    @BeforeAll
    public static void setUp() {
        holiday=new Holiday("New Year", "2025-01-01");
        holidayCalendar = new HolidayCalendar();
    }

    @Test
    void addHoliday_positiveTest() {
        holidayCalendar.addHoliday(holiday);
        holidayCalendar.addHoliday(holiday);
        assertEquals(1,holidayCalendar.getHolidays().size());
        Holiday addedHoliday = holidayCalendar.getHolidays().get(0);
        assertEquals(addedHoliday.getName(), holiday.getName());
        assertEquals(addedHoliday.getDate(),holiday.getDate());
    }
    @Test
    void addHoliday_negativeTest() {
        // Ensure the calendar starts empty
        assertTrue(holidayCalendar.getHolidays().isEmpty());

        // Try adding null
        assertThrows(IllegalArgumentException.class, () -> holidayCalendar.addHoliday(null));
        assertTrue(holidayCalendar.getHolidays().isEmpty()); // List should remain empty

        // Try adding a holiday with an empty name
        Holiday invalidHoliday = new Holiday("", "2025-01-01");
        assertThrows(IllegalArgumentException.class, () -> holidayCalendar.addHoliday(invalidHoliday));
        assertTrue(holidayCalendar.getHolidays().isEmpty()); // Still empty

        // Try adding a holiday with a null date
        Holiday holidayWithoutDate = new Holiday("No Date", null);
        assertThrows(IllegalArgumentException.class, () -> holidayCalendar.addHoliday(holidayWithoutDate));
        assertTrue(holidayCalendar.getHolidays().isEmpty()); // Still empty

        // Add a valid holiday
        Holiday holiday = new Holiday("New Year", "2025-01-01");
        holidayCalendar.addHoliday(holiday);
        assertEquals(1, holidayCalendar.getHolidays().size());

        // Try adding the same holiday again (should not create a duplicate)
        holidayCalendar.addHoliday(holiday);
        assertEquals(1, holidayCalendar.getHolidays().size()); // Still only one holiday
    }
    @Test
    void removeHoliday_positiveTest() {
        // Добавляем праздник
        holidayCalendar.addHoliday(holiday);
        assertEquals(1, holidayCalendar.getHolidays().size());

        // Удаляем праздник по имени
        holidayCalendar.removeHoliday(holiday.getName());

        // Проверяем, что праздник удален
        assertEquals(0, holidayCalendar.getHolidays().size());
    }
    @Test
    void getHolidays_positiveTest() {
        // Убеждаемся, что изначально список пуст
        assertTrue(holidayCalendar.getHolidays().isEmpty());

        // Добавляем праздники
        Holiday holiday1 = new Holiday("New Year", "2025-01-01");
        Holiday holiday2 = new Holiday("Christmas", "2025-24-12");

        holidayCalendar.addHoliday(holiday1);
        holidayCalendar.addHoliday(holiday2);

        // Проверяем размер списка
        List<Holiday> holidays = holidayCalendar.getHolidays();
        assertEquals(2, holidays.size());

        // Проверяем, что список содержит нужные праздники
        assertTrue(holidays.contains(holiday1));
        assertTrue(holidays.contains(holiday2));
    }
    @Test
    void getHolidays_negativeTest() {
        // Ensure that an empty calendar returns an empty list, not null
        assertNotNull(holidayCalendar.getHolidays());
        assertTrue(holidayCalendar.getHolidays().isEmpty());

        // Add and then remove a holiday
        Holiday holiday = new Holiday("New Year", "2025-01-01");
        holidayCalendar.addHoliday(holiday);
        assertEquals(1, holidayCalendar.getHolidays().size());

        // Remove the holiday
        holidayCalendar.removeHoliday(holiday.getName());

        // Check that the list is empty again
        assertTrue(holidayCalendar.getHolidays().isEmpty());
    }
    @Test
    void removeHoliday_negativeTest() {
        // Удаление из пустого календаря
        assertTrue(holidayCalendar.getHolidays().isEmpty());
        holidayCalendar.removeHoliday("NonExistingHoliday");
        assertTrue(holidayCalendar.getHolidays().isEmpty());

        // Добавляем один праздник
        Holiday holiday = new Holiday("New Year", "2025-01-01");
        holidayCalendar.addHoliday(holiday);
        assertEquals(1, holidayCalendar.getHolidays().size());

        // Попытка удалить несуществующий праздник
        holidayCalendar.removeHoliday("Christmas");
        assertEquals(1, holidayCalendar.getHolidays().size()); // Должен остаться 1 праздник

        // Удаляем существующий праздник
        holidayCalendar.removeHoliday("New Year");
        assertEquals(0, holidayCalendar.getHolidays().size()); // Теперь список пуст
    }

}