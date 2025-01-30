import org.example.Holiday;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HolidayTest {
    private static Holiday holiday;

    @BeforeAll
    public static void setUp() {
        holiday = new Holiday("New Year", "2025-01-01");
    }

    @Test
    void test_Positive_GetName() {
        assertTrue("New Year".equals(holiday.getName()));
    }

    @Test
    void test_Negative_GetName() {
        assertFalse("New".equals(holiday.getName()));
    }
}
