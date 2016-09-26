/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

import java.time.*;

/**
 *
 * @author 2304moantoine
 */
public class Date {
    private int day;
    private int month;
    private int year;
    private final String[] days   = {"Samedi", "Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"};
    private final String[] months = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre", "janvier", "février"};
    private final int[] nbrDaysPerMonth = {31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30};
    
    public Date(int day, int month, int year) {
        this.setYear(year);
        this.setMonth(month);
        this.setDay(day);
    }
    public Date() {
        this(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(), LocalDate.now().getYear());
    }
    /**
     * 
     * @return int
     */
    public int getDay() {
        return this.day;
    }
    public final void setDay(int day) {
        if(day <= 0 || day > 31 || (day > 28 && this.month == 2 && !this.isLeapYear()) || (day > 29 && this.month == 2 && this.isLeapYear())) throw new RuntimeException("Invalid number of day");
        this.day = day;
    }
    public int getMonth() {
        return this.month;
    }
    public final void setMonth(int month) {
        if(month <= 0 || month > 12) throw new RuntimeException("Invalid number of month");
        this.month = month;
    }
    public int getYear() {
        return this.year;
    }
    public final void setYear(int year) {
        if(year < 0) throw new RuntimeException("Invalid number of year");
        this.year = year;
    }
    public void increment() {
        if(this.day == this.daysInMonth()) {
            this.day = 1;
            if(this.month == 12) {
                month = 1;
                ++this.year;
            } else {
                ++this.month;
            }
        } else {
            ++this.day;
        }
    }
    public static boolean isLeapYear(int year) {
        return ((year % 4) == 0 && (year % 100) != 0) ? true : false;
    }
    public boolean isLeapYear() {
        return this.isLeapYear(this.year);
    }
    public int daysInMonth(int month) {
        return (month == 2 && this.isLeapYear()) ? this.nbrDaysPerMonth[month - 1] + 1 : this.nbrDaysPerMonth[month - 1];
    }
    public int daysInMonth() {
        return this.daysInMonth(this.month);
    }
    public int dayOfYear() {
        int day = 0;
        
        for(int i = 1; i < this.month; ++i) {
            day += this.daysInMonth(i);
        }
        day += this.day;
        
        return day;
    }
    public int dayOfWeek() {
        int K = this.year % 100;
        int J = this.year / 100;
        int m = this.month;
        
        if(m == 1 || m == 2) {
            m += 12;
        }
        
        return (this.day + (((m + 1) * 13) / 5) + K + (K/4) + (J/4) + (5 * J)) % 7;
    }
    
    @Override
    public String toString() {
        return "La date est le " + this.days[this.dayOfWeek()] + " " + this.day + " " + this.months[this.month] + " " + this.year + " qui est le " + this.dayOfYear() + "ème jour de l'année";
    }
    public void prettyPrint() {
        System.out.println(this);
    }
}
