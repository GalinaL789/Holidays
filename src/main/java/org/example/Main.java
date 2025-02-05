package org.example;


import java.util.Scanner;

//hello
public class Main {
    public static void main(String[] args) {
        HolidayCalendar calendar = new HolidayCalendar();
        HolidayUpdater updater = new HolidayUpdater(calendar);
        HolidayNotifier notifier = new HolidayNotifier(calendar);

        updater.start();
        notifier.start();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить праздник");
            System.out.println("2. Удалить праздник");
            System.out.println("3. Просмотреть календарь");
            System.out.println("4. Выйти");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Введите название праздника:");
                    String name = scanner.next();
                    System.out.println("Введите дату праздника в формате 'yyyy-dd-mm':");
                    String date="";
                    while (!date.contains("-")) {
                        date = scanner.next();
                    }

                    calendar.addHoliday(new Holiday(name, date));

                    break;
                case 2:
                    System.out.println("Введите название праздника для удаления:");
                    String nameToRemove = scanner.next();
                    calendar.removeHoliday(nameToRemove);
                    break;
                case 3:
                    calendar.displayHolidays();
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }
}

