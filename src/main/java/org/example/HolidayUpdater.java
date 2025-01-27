package org.example;



class HolidayUpdater extends Thread {
    private HolidayCalendar calendar;

    public HolidayUpdater(HolidayCalendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Задержка в 3 секунды
                Thread.sleep(1000);
                System.out.println("Calendar is updating");
                System.out.println("Calendar is updated, the number of Holidays is {}" + calendar.getHolidays().size());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


