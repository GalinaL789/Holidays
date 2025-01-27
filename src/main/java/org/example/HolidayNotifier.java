package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;




class HolidayNotifier extends Thread {
    private HolidayCalendar calendar;
    private List<Holiday> holidays;

    public HolidayNotifier(HolidayCalendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void run() {
        holidays=calendar.getHolidays();
        while (true) {
            LocalDate currentDate = LocalDate.now();
            for (Holiday holiday : holidays) {
                if (holiday.getDate().isEqual(currentDate)) {
                    System.out.println("Сегодня " + holiday.getName() + " !");
                    try {
                        // Пауза между проверками (например, каждые 24 часа)
                        Thread.sleep(30000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

