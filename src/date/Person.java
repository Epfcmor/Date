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
public class Person {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private final LocalDate today = LocalDate.now();
    
    public Person(String firstName, String lastName, int day, int month, int year) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setDateOfBirth(day, month, year);
    }
    
    public String getFirstName() {
        return firstName;
    }
    public final void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public final void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }
    public final void setDateOfBirth(int day, int month, int year) {
        this.dateOfBirth = new Date(day, month, year);
    }
    public int getAge() {
        int age = this.today.getYear() - this.dateOfBirth.getYear();
        if(this.dateOfBirth.getMonth() > this.today.getMonthValue() || (this.dateOfBirth.getMonth() == this.today.getMonthValue() && this.dateOfBirth.getDay() > this.today.getDayOfMonth())) {
            age -= 1;
        }
        
        return age;
    }
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " est âgé de " + this.getAge() + " ans";
    }
}
