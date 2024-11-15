//Name: Sadiya Maheen Siddiqui
//Class: BE 2nd Year, CSE
//Roll Number: 100523733050
//Mini Coding Project - 1 Using Java

import java.time.*;

class UserDefinedException extends Exception {
    public UserDefinedException(String message) {
        super(message);
    }
}

public class Project {
    public static void ThrowException(String message) {
        try {
            throw new UserDefinedException(message);
        } catch (UserDefinedException ude) {
            System.out.println(ude.getMessage());
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        int i = 0;
        if (args.length != 4) {
            ThrowException("Provide Exactly 4 Arguments");
        }
        String[] arguments = new String[4];
        for (String arg : args) {
            arguments[i++] = arg;
        }
        String type = arguments[0].substring(0, 3);
        switch (type) {
            case "DOB":
                calculateDOB(arguments);
                break;
            case "AGE":
                calculateAge(arguments);
                break;
            default:
                ThrowException("Invalid Format of the First Argument");

        }
    }

    public static boolean checkDateOrder(LocalDate date, LocalDate refDate) {
        if (date.isAfter(refDate)) {
            return false;
        }
        return true;
    }

    public static void calculateDOB(String[] arguments) {
        String del = arguments[3];
        String[] date = arguments[0].substring(4, 14).split(del);
        String[] refDate = arguments[1].split(del);
        String dateFormat = arguments[2].substring(0, 2);
        LocalDate date1 = null, date2 = null;
        switch (dateFormat) {
            case "DD":
                date1 = LocalDate.of(Integer.valueOf(date[2]), Integer.valueOf(date[1]), Integer.valueOf(date[0]));
                date2 = LocalDate.of(Integer.valueOf(refDate[2]), Integer.valueOf(refDate[1]),
                        Integer.valueOf(refDate[0])).plusDays(1);
                break;
            case "MM":
                date1 = LocalDate.of(Integer.valueOf(date[2]), Integer.valueOf(date[0]), Integer.valueOf(date[1]));
                date2 = LocalDate.of(Integer.valueOf(refDate[2]), Integer.valueOf(refDate[0]),
                        Integer.valueOf(refDate[1])).plusDays(1);
                break;
            case "YY":
                date1 = LocalDate.of(Integer.valueOf(date[0]), Integer.valueOf(date[1]), Integer.valueOf(date[2]));
                date2 = LocalDate.of(Integer.valueOf(refDate[0]), Integer.valueOf(refDate[1]),
                        Integer.valueOf(refDate[2])).plusDays(1);
                break;
            default:
                ThrowException("Invalid Date Format");
        }
        if (!checkDateOrder(date1, date2)) {
            ThrowException("The Reference Date is prior to the Date of Birth");
        }
        Period between = Period.between(date1, date2);
        System.out.println("Your Age : " + between.getYears() + " years, " + between.getMonths() + " months, "
                + between.getDays() + " days");
    }

    public static void calculateAge(String[] arguments) {
        String del = arguments[3];
        String[] date = arguments[0].substring(4, 14).split(del);
        String[] refDate = arguments[1].split(del);
        String dateFormat = arguments[2].substring(0, 2);
        LocalDate date2 = null;
        int year = 0, month = 0, day = 0;
        switch (dateFormat) {
            case "DD":
                year = Integer.valueOf(date[2]);
                month = Integer.valueOf(date[1]);
                day = Integer.valueOf(date[0]);
                date2 = LocalDate.of(Integer.valueOf(refDate[2]), Integer.valueOf(refDate[1]),
                        Integer.valueOf(refDate[0])).plusDays(1);
                break;
            case "MM":
                year = Integer.valueOf(date[2]);
                month = Integer.valueOf(date[0]);
                day = Integer.valueOf(date[1]);
                date2 = LocalDate.of(Integer.valueOf(refDate[2]), Integer.valueOf(refDate[0]),
                        Integer.valueOf(refDate[1])).plusDays(1);
                break;
            case "YY":
                year = Integer.valueOf(date[0]);
                month = Integer.valueOf(date[1]);
                day = Integer.valueOf(date[2]);
                date2 = LocalDate.of(Integer.valueOf(refDate[0]), Integer.valueOf(refDate[1]),
                        Integer.valueOf(refDate[2])).plusDays(1);
                break;
            default:
                ThrowException("Invalid Date Format");
        }
        LocalDate DOB = date2.minusYears(year).minusMonths(month).minusDays(day);
        System.out.println("Your DOB : " + String.format("%02d", DOB.getDayOfMonth()) + "-"
                + String.format("%02d", DOB.getMonthValue()) + "-" + String.format("%04d", DOB.getYear()));
    }
}
