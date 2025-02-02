import org.example.Holiday;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
}
