import org.example.Holiday;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class HolidayTest {
    private static Holiday holiday;

    @BeforeAll
    public static void setUp() {
        holiday = new Holiday("New Year", "2025-01-01");
    }

    @Test
    void test_Positive_GetName() {
        assertEquals("New Year", holiday.getName());
    }

    @Test
    void test_Negative_GetName() {
        assertNotEquals("New", holiday.getName());
    }

    @Test
    void test_Constructor_Valid() {
        Holiday validHoliday = new Holiday("Christmas", "2024-12-25");
        assertEquals("Christmas", validHoliday.getName());
        assertEquals(LocalDate.of(2024, 12, 25), validHoliday.getDate());
    }

    @Test
    void test_Constructor_Invalid_Name() {
        Exception exception = assertThrows(RuntimeException.class, () -> new Holiday("1234", "2025-01-01"));
        assertTrue(exception.getMessage().contains("the title of holiday is incorrect"));
    }
}
