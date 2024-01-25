package main.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddDays {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide a date (dd-MM-yyyy) and a number of days as command line arguments.");
            return;
        }

        LocalDate inputDate = parseDate(args[0]);
        int daysToAdd = Integer.parseInt(args[1]);
        LocalDate resultDate = inputDate.plusDays(daysToAdd);
        System.out.println("Result of adding " + daysToAdd + " days to " +
                inputDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ": " +
                resultDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }

    private static LocalDate parseDate(String dateString) {
        try {
            return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (Exception e) {
            System.out.println("Error parsing date: " + dateString);
            System.exit(1);
            return null;
        }
    }
}
