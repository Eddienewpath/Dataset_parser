package com.company;

public class Date implements Comparable<Date> {

    private int month;
    private int day;
    private int year;

    public Date(String string) {
        String date[] = string.split("/");
        try {
            this.month = Integer.valueOf(date[1]);
            this.day = Integer.valueOf(date[2]);
            this.year = Integer.valueOf(date[0]);
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
        }
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public int compareTo(Date date) {
        if (Integer.compare(year, date.getYear()) != 0)
            return Integer.compare(year, date.getYear());
        else if (Integer.compare(month, date.getMonth()) != 0)
            return Integer.compare(month, date.getMonth());
        else
            return Integer.compare(day, date.getDay());
    }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }
}
