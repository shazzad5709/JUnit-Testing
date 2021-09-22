package ir.maktab58.homework4.MyDate;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean isValidDate(int day, int month, int year) {
        if (month > 0 && month <= 12 && year > 0 && year <= 9999) {
            if (month > 0 && month < 7 && day > 0 && day <= 31)
                return true;
            else if (month >= 7 && month < 12 && day > 0 && day <= 30)
                return true;
            else if (month == 12 && day > 0 && day <= 29)
                return true;
            else
                return false;
        }
        return false;
    }

    public int getMonthLastDay(int month) {
        if (month > 0 && month < 7)
            return 31;
        else if (month >= 7 && month < 12)
            return 30;
        else if (month == 12)
            return 29;
        else
            return -1;
    }

    public void nextDay(){
        boolean dateChecker;
        dateChecker = isValidDate(year, month, day + 1);
        if (dateChecker) {
            day += 1;
            return;
        }
        dateChecker = isValidDate(year, month + 1, 1);
        if (dateChecker) {
            day = 1;
            month += 1;
            return;
        }
        dateChecker = isValidDate(year + 1, 1, 1);
        if (dateChecker) {
            day = 1;
            month = 1;
            year += 1;
            return;
        }
        year = 1;
        month = 1;
        day = 1;
        System.out.println("You should check year limits.");
    }

    @Override
    public String toString() {
        String monthName = "";
        switch (month){
            case 1:
                monthName = "Farvardin";
                break;
            case 2:
                monthName = "Ordibehesht";
                break;
            case 3:
                monthName = "Khordad";
                break;
            case 4:
                monthName = "Tir";
                break;
            case 5:
                monthName = "Mordad";
                break;
            case 6:
                monthName = "Shahrivar";
                break;
            case 7:
                monthName = "Mehr";
                break;
            case 8:
                monthName = "Aban";
                break;
            case 9:
                monthName = "Azar";
                break;
            case 10:
                monthName = "Dey";
                break;
            case 11:
                monthName = "Bahman";
                break;
            case 12:
                monthName = "Esfand";
                break;
            default:
                monthName = "Invalid amount for month";
                break;
        }
        return day + " " + monthName + " " + year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
